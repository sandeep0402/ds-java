package ds.misc;

/*
 * http://stackoverflow.com/questions/742013/how-to-code-a-url-shortener
 * http://massivetechinterview.blogspot.in/2015/06/how-to-design-tiny-url-or-url-shortener.html
 */
public class UrlShortener {  
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
    private static final int    BASE     = ALPHABET.length();  
  
    public static String encode(int num) {  
        StringBuilder sb = new StringBuilder();  
  
        while ( num > 0 ) {  
            sb.append( ALPHABET.charAt( num % BASE ) );  
            num /= BASE;  
        }  
  
       return sb.reverse().toString();     
    }  
  
    public static int decode(String str) {  
        int num = 0;  
  
        for ( int i = 0, len = str.length(); i < len; i++ ) {  
            num = num * BASE + ALPHABET.indexOf( str.charAt(i) );   
        }  
  
        return num;  
    }     
    public static void main(String[] args) {
		String url = "2015/06/how-to-design-tiny-url-or-url-shortener.html";
		int id = 100002;
		System.out.println("Given DB id = " + id);
		String shortUrl = encode(id);
		System.out.println("shortUrl = " + shortUrl);
		int retrievedId = decode(shortUrl);
		System.out.println("DB Id found from url = "+ retrievedId);
		
	}
}  