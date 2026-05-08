import static java.lang.IO.println;

void main() {

    Result good = new Success("User profile loaded.");
    Result bad = new Failure("Connection timed out", 504);

    handleResult(good);
    handleResult(bad);
}

void handleResult(Result result) {
    switch (result) {
        case Success success -> println("success: %s".formatted(success.data()));
        case Failure failure ->
                println("Failure: errorMessage: %s errorcode: %d".formatted(failure.errorMessage(), failure.errorcode()));
    }
}

sealed interface Result permits Success, Failure {

}

record Success(String data) implements Result {
}

record Failure(String errorMessage, int errorcode) implements Result {
}