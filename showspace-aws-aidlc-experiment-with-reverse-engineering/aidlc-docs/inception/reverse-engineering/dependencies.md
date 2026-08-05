# Dependencies

## Internal Dependencies

```mermaid
flowchart TD
    subgraph Controllers
        HC[HomeController]
        CC[CatalogController]
        BC[BookingController]
    end
    
    subgraph Services
        CS[CatalogService]
        BS[BookingService]
    end
    
    subgraph Repositories
        MR[MovieRepository]
        BR[BookingRepository]
        SR[ShowtimeRepository]
        SeR[SeatRepository]
        TR[TicketRepository]
    end
    
    subgraph Database
        PG[PostgreSQL]
    end
    
    CC --> CS
    BC --> BS
    CS --> MR
    BS --> SR
    BS --> SeR
    BS --> BR
    BS --> TR
    MR --> PG
    BR --> PG
    SR --> PG
    SeR --> PG
    TR --> PG
```

### CatalogService depends on MovieRepository
- **Type**: Compile/Runtime
- **Reason**: Data access for movie entities

### BookingService depends on ShowtimeRepository
- **Type**: Compile/Runtime
- **Reason**: Data access for showtime entities

### BookingService depends on SeatRepository
- **Type**: Compile/Runtime
- **Reason**: Data access for seat entities and status updates

### BookingService depends on BookingRepository
- **Type**: Compile/Runtime
- **Reason**: Data access for booking entities

### BookingService depends on TicketRepository
- **Type**: Compile/Runtime
- **Reason**: Data access for ticket entities

## External Dependencies

### Spring Framework
- **Version**: 5.3.31
- **Purpose**: Core framework for dependency injection, MVC, and transaction management
- **License**: Apache License 2.0

### PostgreSQL JDBC Driver
- **Version**: 42.7.2
- **Purpose**: Database connectivity to PostgreSQL
- **License**: BSD-2-Clause

### Servlet API
- **Version**: 4.0.1
- **Purpose**: Standard Java web API for request/response handling
- **License**: CDDL/GPL

### JSTL
- **Version**: 1.2
- **Purpose**: JSP tag libraries for simplified view development
- **License**: CDDL/GPL