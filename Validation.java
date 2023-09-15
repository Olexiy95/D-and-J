public class Validation
{
    public Validation()
    {

    }

    public static boolean isBlank(String value)
    {
        boolean blank = true;
        if (value.trim().length() > 0)
            blank = false;
            return blank;
    }

    public static boolean lengthWithinRange(String value, int min, int max)
        {
            boolean withinRange = false;
            if ((value.trim().length() >= min) && (value.trim().length() <= max))
                withinRange = true;
                return withinRange;
        }

}
