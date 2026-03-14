import static java.lang.IO.println;

void main() {
    new CSVHandler().process("data.csv", "name,age,email");
    new JSONHandler().process("data.json", "{\"name\": \"Alice\"}");
}

abstract class FileHandler {

    abstract String read(String fileName);

    abstract void write(String fileName, String content);

    abstract boolean validate(String content);

    void process(String fileName, String content) {
        String type = getClass().getSimpleName();
        println("[" + type + "] Validating... " +
                (validate(content) ? "OK" : "FAILED"));
        write(fileName, content);
        println("[" + type + "] Reading: " + read(fileName));
    }
}

interface Compressible {

    default String compress(String content) {
        return "[Compressed] %s".formatted(content);
    }

    default String deCompress(String content) {
        return content.replace("[Compressed]", "");
    }
}

class CSVHandler extends FileHandler {

    @Override
    String read(String fileName) {
        return "CSV data from " + fileName;
    }

    @Override
    void write(String fileName, String content) {
        println("[CSV] Writing to " + fileName + "...");
    }

    @Override
    boolean validate(String content) {
        return content.contains(",");
    }
}

class JSONHandler extends FileHandler implements Compressible {

    @Override
    String read(String fileName) {
        return "JSON data from " + fileName;
    }

    @Override
    void write(String fileName, String content) {
        System.out.println("[JSON] Writing compressed to " + fileName + "...");
        System.out.println("[JSON] Compressed: " + compress(content));
    }

    @Override
    boolean validate(String content) {
        return content.strip().startsWith("{") || content.strip().startsWith("[");
    }
}