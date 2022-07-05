# Spring Shell JPA boiler plate

A [Spring Shell](https://spring.io/projects/spring-shell) boilerplate application with JPA support based on H2 (repleacable). The application supports rendering entities in a shell using a table format. An example database contains one example `Currency` entity. 

## Examples

```bash
$ ./run.sh

shell:>help
AVAILABLE COMMANDS

Built-In Commands
       help: Display help about available commands
       exit: Exit the shell.
       stacktrace: Display the full stacktrace of the last error.
       clear: Clear the shell screen.
       quit: Exit the shell.
       history: Display or save the history of previously run commands
       version: Show version info
       script: Read and execute commands from a file.

config
       config-display-mode-list: Lists possible display modes.
       config-display-size: Reads or sets display size for tables.
       config-display-mode: Reads or sets display mode.

currency
       currency-rate-list: Lists all currency rates or displays a single currency rate.
       currency-list: Lists all currencies.
       currency-rate: Sets or displays currency rate.

shell:>currency-rate-list
+--------+------+
|currency|rate  |
+--------+------+
|PLN     |1.0000|
+--------+------+
|EUR     |1.0000|
+--------+------+
|USD     |1.0000|
+--------+------+

shell:>config-display-mode PLAIN
PLAIN

shell:>currency-rate-list
currency=PLN
rate=1.0000

currency=EUR
rate=1.0000

currency=USD
rate=1.0000

shell:>currency-rate USD
1.0000

shell:>currency-rate USD 2.0
2.0000

shell:>currency-rate USD 
2.0000

shell:>config-display-mode TABLE
TABLE

shell:>currency-rate-list 
+--------+------+
|currency|rate  |
+--------+------+
|PLN     |1.0000|
+--------+------+
|EUR     |1.0000|
+--------+------+
|USD     |2.0000|
+--------+------+
```
