# pdf-sandbox

## What to do?

This api will transcribe specified text to PDF that specified URL.

```plantuml
@startuml

(Download PDF) as (dl)
(Transcribe text to PDF) as (ts)
(Save PDF) as (sv)

(dl) --> (ts)
(ts) --> (sv)

@enduml

