package wiproPracticeDay1;

public class Enum {
	enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL,
        MAY, JUNE, JULY, AUGUST,
        SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

	public static void main(String[] args) {
		for (Month m : Month.values()) {
            System.out.println(m);
        }
	Month month = Month.FEBRUARY;
	if (month == Month.FEBRUARY) {
        System.out.println("is FEBRUARY.");
    } else {
        System.out.println(" is not FEBRUARY.");
    }

	}

}
