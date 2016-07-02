/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translation;

/**
 *
 * @author Tami
 */
public enum Languages {

    Azerbaijan("az"), Malagasy("mg"),
    Albanian("sq"), Malay("ms"),
    English("en"), Maltese("mt"),
    Arabic("ar"), Macedonian("mk"),
    Armenian("hy"), Mongolian("mn"),
    Afrikaans("af"), German("de"),
    Basque("eu"), Norwegian("no"),
    Bashkir("ba"), Punjabi("pa"),
    Belarusian("be"), Persian("fa"),
    Bengali("bn"), Polish("pl"),
    Bulgarian("bg"), Portuguese("pt"),
    Bosnian("bs"), Romanian("ro"),
    Welsh("cy"), Russian("ru"),
    Hungarian("hu"), Serbian("sr"),
    Vietnamese("vi"), Sinhala("si"),
    Haitian("ht"), Slovakian("sk"),
    Galician("gl"), Slovenian("sl"),
    Dutch("nl"), Swahili("sw"),
    Greek("el"), Tajik("tg"),
    Georgian("ka"), Thai("th"),
    Gujarati("gu"), Tagalog("tl"),
    Danish("da"), Tamil("ta"),
    Hebrew("he"), Tatar("tt"),
    Indonesian("id"), Turkish("tr"),
    Irish("ga"), Udmurt("udm"),
    Italian("it"), Uzbek("uz"),
    Icelandic("is"), Ukrainian("uk"),
    Spanish("es"), Urdu("ur"),
    Kazakh("kk"), Finish("fi"),
    Kannada("kn"), French("fr"),
    Catalan("ca"), Hindi("hi"),
    Kyrgyz("ky"), Croatian("hr"),
    Chinese("zh"), Czech("cs"),
    Korean("ko"), Swedish("sv"),
    Latin("la"), Estonian("et"),
    Latvian("lv"), Japanese("ja"),
    Lithuanian("lt");
    private final String language;

    private Languages(final String pLanguage) {
        language = pLanguage;
    }

    public static Languages fromString(final String pLanguage) {
        for (Languages i : values()) {
            if (i.toString().equals(pLanguage)) {
                return i;
            }
        }
        return null;
    }

    public static void listString() {
        System.out.println("Language: code");
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < values().length; i++) {
            sb.append(values()[i].name()).append(": "+values()[i]).append("   ");
            if ((i + 1) % 8 == 0) {
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    @Override
    public String toString() {
        return language;
    }
}
