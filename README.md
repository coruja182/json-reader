# Json File Reader

Uses the Jackson library to parse a JSON file provided as command-line argument

## Requirements

- Java 17

## Input file format

```json
[
  {
    "name": "Coruja One Eight Two",
    "height": 182
  },
  {
    "name": "Son Goku",
    "height": 175
  }
]
```

## Build Application

### Generate executable script

```shell
./gradlew installDist

# the application bundle will be stored in folder `./build/install/`

# To execute it:

# Unix based systems
./build/install/json-reader/bin/json-reader <json-fie>
./build/install/json-reader/bin/json-reader src/test/resources/input-test.json

# Windows
.\build\install\json-reader\bin\json-reader.bat <json-fie>
.\build\install\json-reader\bin\json-reader.bat src\test\resources\input-test.json
```
