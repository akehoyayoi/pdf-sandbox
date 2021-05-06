# PDF transcriber

## What to do?

This api will transcribe specified text to PDF that specified URL.

PDF + sentences -> transcribed PDF

![Image](doc/what_is_doing.png)

## Process flow for design

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
```

## How to execute this application on local

```bash
./gradlew bootRun
```

## How to use this API?

```bash
curl --location --request POST 'http://localhost:8080/v1/transcribe' \
--header 'Content-Type: application/json' \
--data-raw '{
	"url" : "https://www.chofu-across.jp/CMS/wp-content/uploads/2019/06/shinseisho_shisetsu_chusen_r12.pdf",
	"sentences": 
	[
		{"content":"田中一郎", "fontSize": 12.0, "offsetX": 200.0, "offsetY": 660.0, "page": 0}
	]
}' > sample.pdf
```

