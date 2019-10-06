public class Transliteration
{
    private static String asc = "abgdevzTiklmnopJrstufqRySCcZwWxjh";
    private static String unc = "აბგდევზთიკლმნოპჟრსტუფქღყშჩცძწჭხჯჰ";

    public static String translateToGeo(String vl)
    {
        StringBuilder sb = new StringBuilder();
        for (char c : vl.toCharArray())
        {
            int ind1 = asc.indexOf(c);
            char charToAppend = ind1 < 0 ? c : unc.charAt(ind1);
            sb.append(charToAppend);
        }
        return sb.toString();
    }

}
