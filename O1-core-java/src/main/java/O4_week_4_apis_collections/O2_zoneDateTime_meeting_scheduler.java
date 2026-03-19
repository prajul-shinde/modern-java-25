import static java.lang.IO.println;

void main() {
    ZonedDateTime meeting = ZonedDateTime.of(LocalDateTime.of(2024, 03, 15, 10, 0),
                                             ZoneId.of("America/New_York"));

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm z");

    String[][] zones = {
            {"New York", "America/New_York"},
            {"London", "Europe/London"},
            {"Paris", "Europe/Paris"},
            {"India", "Asia/Kolkata"},
            {"Tokyo", "Asia/Tokyo"},
            {"Sydney", "Australia/Sydney"}
    };

    println("Meeting Time across timezones");
    println("=".repeat(60));

    for (var zone : zones) {
        ZonedDateTime local = meeting.withZoneSameInstant(ZoneId.of(zone[1]));
        int hour = local.getHour();
        String warning = (hour < 9 || hour >= 18) ? " Outside business hours" : "";
        println("%-12s: %s%s%n".formatted(zone[0], local.format(dateTimeFormatter), warning));
    }
}