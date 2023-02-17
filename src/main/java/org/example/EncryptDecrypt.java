package org.example;

import java.util.Random;

/**
 *
 * @author maha
 */
public class EncryptDecrypt {

    /**this instance variable contains the size of the plainText in the ThreeTenCipher class.
     *
     */
    private int plainTextSize;

    /** plainTextSize setter
     *
     * @param s set equal to the length of plainText from ThreeTenCipher class
     */
    public void setPlainTextSize(int s) {
        plainTextSize = s;
    }

    /** plainTextSize getter
     *
     * @return the plainTextSize
     */
    public int getPlainTextSize() {
        return plainTextSize;
    }

    /**this integer array of size equal to plainTextSize
     * contains the random numbers to be used by the encrypt/decrypt methods
     *
     */
    private int[] selectAlpha;

    /**first randomly sets the selectAlpha array to random numbers between 0 and 4 this number indicates which alphabet cipher is used for each letter in plainText
     * accesses the plainText in the ThreeTenCipher then
     * encrypts it and sets the cipherText in the ThreeTenCipher
     */
    public void encrypt() {
        ThreeTenCipher cipher = new ThreeTenCipher();
        cipher.setPlainText(ThreeTenCipher.plainText);
        selectAlpha = generateRandomArray(plainTextSize);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < plainTextSize; i++) {
            char c = ThreeTenCipher.plainText.charAt(i);
            int selectedAlpha = selectAlpha[i];
            int offset = keys[selectedAlpha][c - 'A'] - 'A';
            char encrypted = (char) ((c - 'A' + offset) % 26 + 'A');
            cipher.
            result.append(encrypted);
        }

        ThreeTenCipher.cipherText = result.toString();
    }

    /** uses the cipherText from the ThreeTenCipher and the instance variable selectAlpha
     * decrypts the cipher text
     * then calls the archiveDecrypted to store the resulting string in the ThreeTenCipher testArchive instance variable.
     * @return  returns the resulting text.
     */
    public String decrypt() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < plainTextSize; i++) {
            char c = ThreeTenCipher.cipherText.charAt(i);
            int selectedAlpha = selectAlpha[i];
            int offset = keys[selectedAlpha][c - 'A'] - 'A';
            char decrypted = (char) ((c - 'A' - offset + 26) % 26 + 'A');
            result.append(decrypted);
        }

        String decryptedText = result.toString();
        if()
        ThreeTenCipher.insertText(decryptedText.toCharArray());
        return decryptedText;
    }

    /** This functions returns an integer array of random numbers 0~4
     * @param size is the array size
     * @return returns the resulting array.
     */
    private int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(4);
        }
        return result;
    }


}