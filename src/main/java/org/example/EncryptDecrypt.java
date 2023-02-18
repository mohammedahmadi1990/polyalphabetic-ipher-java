package org.example;

/**
 * @author Med
 */

import java.util.Random;
public class EncryptDecrypt {

    /**
     * this instance variable contains the size of the plainText in the ThreeTenCipher class.
     */
    private int plainTextSize;

    /**
     * plainTextSize setter.
     *
     * @param s set equal to the length of plainText from ThreeTenCipher class
     */
    public void setPlainTextSize(int s) {
        plainTextSize = s;
    }

    /**
     * plainTextSize getter
     *
     * @return the plainTextSize
     */
    public int getPlainTextSize() {
        return plainTextSize;
    }

    /**
     * this integer array of size equal to plainTextSize
     * contains the random numbers to be used by the encrypt/decrypt methods
     */
    private int[] selectAlpha;

    /**
     * first randomly sets the selectAlpha array to random numbers
     * between 0 and 4 this number indicates which alphabet cipher is used for each letter in plainText
     * accesses the plainText in the ThreeTenCipher then
     * encrypts it and sets the cipherText in the ThreeTenCipher
     */
    public void encrypt() {

        // generating array of random numbers
        selectAlpha = new int[plainTextSize];
        Random rand = new Random();
        for (int i = 0; i < plainTextSize; i++) {
            selectAlpha[i] = rand.nextInt(5); //random number [0~4]
        }

        String plainText = ThreeTenCipher.plainText.toUpperCase();
        StringBuilder cipherTextBuilder = new StringBuilder();
        for (int i = 0; i < plainTextSize; i++) {
            // loop for all the characters of the enter plain text
            int cipherAlphabetIndex = selectAlpha[i];
            char plainChar = plainText.charAt(i);
            char cipherChar = ' ';
            // check to enter alphabet only
            if ((plainChar - 65 >= 0) && (plainChar - 65 < 26)) {
                cipherChar = ThreeTenCipher.keys[cipherAlphabetIndex][((int) plainChar - 65)];
            } else {
                cipherChar = plainChar;
            }
            cipherTextBuilder.append(cipherChar); // append to the string
        }

        // store in the cipherText static variable
        ThreeTenCipher.cipherText = cipherTextBuilder.toString();
    }

    /**
     * uses the cipherText from the ThreeTenCipher and the instance variable selectAlpha
     * decrypts the cipher text
     * then calls the archiveDecrypted to store the resulting string in the ThreeTenCipher testArchive instance variable.
     *
     * @return returns the resulting plain text.
     */
    public String decrypt() {
        StringBuilder plainTextBuilder = new StringBuilder();
        for (int i = 0; i < plainTextSize; i++) {
            int cipherAlphabetIndex = selectAlpha[i];
            char cipherChar = ThreeTenCipher.cipherText.charAt(i);
            int plainCharIndex = 0;
            // check inside the key list to find the mapping
            for (int j = 0; j < 26; j++) {
                if (ThreeTenCipher.keys[cipherAlphabetIndex][j] == cipherChar) {
                    plainCharIndex = j;
                    break;
                }
            }
            char plainChar = ' ';
            // checking for alphabets only
            if ((cipherChar - 65 >= 0) && (cipherChar - 65 < 26)) {
                if (i == 0) {
                    // according to the sample first characters are uppercase and then others are lower case
                    // in fact, to have case-sensitive cipher,
                    // we need to have a list of keys for punctuations and lower-cases
                    plainChar = (char) (plainCharIndex + 65); //uppercase
                } else {
                    plainChar = (char) (plainCharIndex + 97); // lowercase
                }
            } else {
                plainChar = cipherChar;
            }
            plainTextBuilder.append(plainChar); // append to the built string
        }
        String plainText = plainTextBuilder.toString();

        ThreeTenCipher threeTenCipher = new ThreeTenCipher();
        threeTenCipher.insertText(plainText.toCharArray());
//        System.out.println(plainText); // you can see the output of decrypt
        return plainText;
    }


}