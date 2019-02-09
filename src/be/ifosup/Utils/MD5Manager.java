package be.ifosup.Utils;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Manager {

    private MD5Manager() {}

    private static MD5Manager instance = null;

    public static MD5Manager Instance () {
        if (instance == null) {
            instance = new MD5Manager();
        }
        return instance;
    }

    public String hash(String pass){


        //String mdme ="";

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

        //mdme = myHash;

    return myHash.toLowerCase();}

}
