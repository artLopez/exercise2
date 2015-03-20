function assert () {
  if [[ "$1" = "$2" ]]; then
    echo success
    exit 0
  else
    echo error: $1 does not equal $2
    exit 1
  fi
}

actual   = `java -cp test-1.0-SNAPSHOT.jar edu.csumb.app.App arlopez@csumb.edu 2`
expected = "[mcockman@csumb.edu, arlopez@csumb.edu, agopar@csumb.edu]"

assert "$actual" "$expected"
