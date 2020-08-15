package vn.com.vng.alphadriver.domain.authen;

public interface AuthenProvider {
    String getAuthen();
    String getAuthen(String username, String passWord);
}
