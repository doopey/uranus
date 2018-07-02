kill -9 `ps aux | grep "uranus-0.0.1-SNAPSHOT" | grep -v "grep" | awk '{print $2}'`
