# POC Mali
A study for learn how [mali](https://github.com/metosin/malli) works

<hr/>

![Clojure](https://img.shields.io/static/v1?label=Clojure&color=27ae60&message=v1.10.1&style=for-the-badge&logo=Clojure&logoColor=white)
![Java](https://img.shields.io/static/v1?label=Java&color=e74c3c&message=open-jdk-8+&style=for-the-badge&logo=Java)
![Emacs](https://img.shields.io/static/v1?label=Made%20With&message=Emacs&color=9b59b6&style=for-the-badge&logo=GNU-Emacs)

## Installation

Clone this repository

``` shell
git clone https://github.com/YuhriBernardes/poc-malli.git
```

## Usage
Ensure that your current directory is the project root

### Clojure

``` shell
clojure -m poc.main
```

### Java

1. Download the jar file on [`release`](https://github.com/YuhriBernardes/poc-malli/releases/tag/1.0.0) section or run `clojure -A:uberjar`

2. Execute jar file
``` shell
java -jar target/poc_malli.jar
```

### Docker

1. Build container

``` shell
docker build -t malli:poc .
```

2. Run container in interactive mode

``` shell
docker run --rm -it malli:poc
```

## Examples

## License

Copyright © 2020 Yuhri

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
