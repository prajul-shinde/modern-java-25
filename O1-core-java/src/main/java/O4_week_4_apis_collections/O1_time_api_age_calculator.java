import static java.lang.IO.println;

void main() {

    LocalDate birthDate = LocalDate.of(1995, 10, 19);
    LocalDate today = LocalDate.now();
    Period between = Period.between(birthDate, today);
    int years = between.getYears();
    int months = between.getMonths();
    int days = between.getDays();
    long daysLived = ChronoUnit.DAYS.between(birthDate, today);
    LocalDate nextBirthDay = birthDate.withYear(today.getYear());
    long daysBetweenNextBirthday = ChronoUnit.DAYS.between(today, nextBirthDay);

    String result = """
            Birth Date: %s
            Today: %s
            Age: %d years, %d months, %d days
            Total days lived: %d
            Next birthday: %s
            Days between next birthday: %d
            """.formatted(birthDate, today, years, months, days, daysLived, nextBirthDay, daysBetweenNextBirthday);
    println(result);

}