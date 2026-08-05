# DDD Domain Model: Catalog Unit

## 1. Aggregates

### 1.1 Movie Aggregate
The central aggregate for the Catalog unit. It holds the core information about a film, its formats, and its lifecycle metadata. It ensures the consistency of the movie's presentable state (Now Showing vs. Coming Soon) and the formats it supports.
- **Aggregate Root:** `Movie`

---

## 2. Entities

### 2.1 Movie
Represents a film available in the cinema network.
- **Attributes:**
  - `MovieId` (Identity)
  - `Title` (String)
  - `Synopsis` (String)
  - `ReleaseDate` (Date/Time)
  - `TrailerUrl` (String, Optional)
  - `PosterImageUrl` (String, Optional)
- **Behaviors:**
  - `AddFormat(MovieFormat format, AudioLanguage language)`
  - `UpdateMetadata(MovieMetadata metadata)`
  - `GetStatus(CurrentDate date)` -> Returns `MovieStatus`

---

## 3. Value Objects

### 3.1 MovieMetadata
Encapsulates the immutable descriptive characteristics of a movie.
- **Attributes:**
  - `Genre` (String or Enum - e.g., Action, Comedy)
  - `DurationInMinutes` (Integer)
  - `CountryOfOrigin` (String)
  - `AgeRating` (String or Enum - e.g., PG-13, R, G)

### 3.2 MovieFormat
Represents the visual projection format of the movie.
- **Attributes:**
  - `FormatType` (Enum - e.g., 2D, 3D, IMAX)

### 3.3 AudioLanguage
Represents the auditory experience of the format.
- **Attributes:**
  - `LanguageType` (Enum - e.g., Dubbed, Subtitled, Original)

### 3.4 MovieStatus
An enumerated state representing the lifecycle of the movie. It is computed dynamically based on the `ReleaseDate` policy.
- **States:**
  - `ComingSoon`
  - `NowShowing`
  - `Archived`

### 3.5 ShowtimeReadModel
A localized read-model representing showtimes sourced from the Booking unit via asynchronous integration. This allows the Catalog unit to answer queries like "Show me movies playing at Cinema X today" without synchronous coupling to the Booking unit.
- **Attributes:**
  - `ShowtimeId` (External Identifier reference)
  - `CinemaId` (External Identifier reference)
  - `StartTime` (Date/Time)
  - `Format` (MovieFormat)
  - `Audio` (AudioLanguage)

---

## 4. Domain Events

### 4.1 MovieRegisteredEvent
- **Trigger:** A new movie is successfully drafted and added to the catalog system.
- **Payload:** `MovieId`, `Title`, `ReleaseDate`

### 4.2 MovieMetadataUpdatedEvent
- **Trigger:** Edits are made to a movie's metadata (e.g., updating the running time or age rating).
- **Payload:** `MovieId`, `MovieMetadata`

### 4.3 MovieReleasedEvent
- **Trigger:** The system detects that the current date has reached the `ReleaseDate`, officially transitioning the movie to "Now Showing".
- **Payload:** `MovieId`, `ReleaseDate`

---

## 5. Domain Policies

### 5.1 MovieLifecyclePolicy
- **Rule:** A movie's lifecycle state is strictly dictated by its `ReleaseDate` relative to the current system date.
  - If `CurrentDate < ReleaseDate`, the status is `ComingSoon`.
  - If `CurrentDate >= ReleaseDate` and the movie has active associated `ShowtimeReadModel`s, the status is `NowShowing`.
  - *(Optional)* If `CurrentDate` is past the release date but no showtimes have existed for X weeks, it transitions to `Archived`.

### 5.2 FormatConstraintPolicy
- **Rule:** A movie cannot be queried for "Now Showing" unless at least one valid combination of `MovieFormat` and `AudioLanguage` has been assigned to it.

---

## 6. Repositories

### 6.1 MovieRepository
- **Responsibility:** Manages the persistence and retrieval of the `Movie` aggregate.
- **Behaviors:**
  - `FindById(MovieId)`
  - `FindNowShowing(CurrentDate)`
  - `FindComingSoon(CurrentDate)`
  - `FindByCinema(CinemaId)` -> Queries the internal `ShowtimeReadModel` to find movies playing at a specific location.
  - `Save(Movie)`

---

## 7. Domain Services

### 7.1 CatalogQueryService
- **Responsibility:** Orchestrates complex, read-heavy filtering logic that spans across multiple movies or requires querying the integrated `ShowtimeReadModel`.
- **Behaviors:**
  - Evaluates cross-cutting queries, such as retrieving all "Now Showing" movies filtered by a specific `CinemaId` and a specific `MovieFormat` (e.g., returning only IMAX movies playing at Cinema A). This service prevents bloating the `Movie` aggregate with complex cross-aggregate querying logic.
