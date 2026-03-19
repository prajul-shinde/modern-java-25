import static java.lang.IO.println;

void main() {

    var startDate = LocalDate.of(2024, 01, 01);
    var endDate = LocalDate.of(2024, 01, 31);

    List<LocalDate> allDates = new ArrayList<>();
    var current = startDate;
    while (!current.isAfter(endDate)) {
        allDates.add(current);
        current = current.plusDays(1);
    }

    List<LocalDate> weekDays = allDates.stream()
            .filter(d -> d.getDayOfWeek() != DayOfWeek.SATURDAY
                    && d.getDayOfWeek() != DayOfWeek.SUNDAY)
            .toList();
    List<LocalDate> mondays = weekDays.stream().filter(d -> d.getDayOfWeek() == DayOfWeek.MONDAY).toList();

    println("Date Range: " + startDate + " to " + endDate);
    println("Total calendar days: " + allDates.size());
    println("Weekdays (Mon-Fri): " + weekDays.size());
    println("Weekend days: " + (allDates.size() - weekDays.size()));
    println("\nMondays in January 2024:");
    println("  " + mondays);

    // Next Friday the 13th
    LocalDate check = startDate;
    while (!(check.getDayOfWeek() == DayOfWeek.FRIDAY && check.getDayOfMonth() == 13)) {
        check = check.plusDays(1);
    }
    println("\nNext Friday the 13th on or after " + startDate + ": " + check);
}