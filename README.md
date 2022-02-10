# Log Analyser

A simple utility to read, parse and flag the evens from a log file.

## To run the app

1. Clone the git repo

```shell
https://github.com/rathodketul/log-analyser.git
```

2. Open the project in an STS or Eclipse.
3. Run the main application by providing command line argument as file name.

Summary of task
Our custom-build server logs different events to a file named logfile.txt. Every event has 2 entries in the file
- one entry when the event was started and another when the event was finished. The entries in the file
have no specific order (a finish event could occur before a start event for a given id)
Every line in the file is a JSON object containing the following event data:
 id - the unique event identifier
 state - whether the event was started or finished (can have values "STARTED" or "FINISHED"
 timestamp - the timestamp of the event in milliseconds
Application Server logs also have the following additional attributes:
 type - type of log
 host - hostname
2
Example contents of logfile.txt:
In the example above, the event scsmbstgrb duration is 1491377495216 - 1491377495213 = 3ms
The longest event is scsmbstgrc (1491377495218 - 1491377495210 = 8ms)
