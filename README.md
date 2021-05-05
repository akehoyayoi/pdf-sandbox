# pdf-sandbox

## What to do?

This api will transcribe specified text to PDF that specified URL.

```plantuml
@startuml

(Download original PDF) as (dl)
(Transcribe text to new PDF) as (ts)
(Save new PDF) as (sv)
(Delete original PDF) as (dp)

(dl) --> (ts)
(ts) --> (sv)
(sv) --> (dp)

@enduml

