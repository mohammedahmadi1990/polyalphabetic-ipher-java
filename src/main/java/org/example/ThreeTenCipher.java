package org.example;

/**
 * @author Med
 */
public class ThreeTenCipher {

    /**
     * constructor that  initializes the keys array, the textArchive,
     * the cipherText, the plaintext, and sets the sizeStored to 0.
     */
    public ThreeTenCipher() {
        keys = new char[5][26];
        cipherText = "";
        plainText = "";
        textArchive = new char[100];
        sizeStored = 0;
    }

    /**
     * stores the 5 cipher alphabets each of 26 characters length.
     */
    public static char[][] keys;

    /**
     * This is the cipher text to be decrypted.
     */
    public static String cipherText;

    /**
     * This is the plain text to be encrypted.
     */
    public static String plainText;

    /**
     * a character array with initial capacity of 100 that contains all decoded text blocks
     */
    private char textArchive[];

    /**
     * the size of the stored text in textArchive.
     */
    private int sizeStored = 0;

    /**
     * Adds a new text to the textArchive.
     * If textArchive is full, it will increase the size to 1.5 the original size to accommodate the new text inserted.
     * This method should be O(n)
     *
     * @param newText the new text to be added to textArchive
     */
    public void insertText(char[] newText) {
        int newSize = sizeStored + newText.length;
        if (newSize > textArchive.length) {
            // Increase the size of textArchive if necessary
            int newCapacity = (int) Math.ceil(newSize * 1.5);
            char[] newTextArchive = new char[newCapacity];
            System.arraycopy(textArchive, 0, newTextArchive, 0, sizeStored);
            textArchive = newTextArchive;
        }
        System.arraycopy(newText, 0, textArchive, sizeStored, newText.length);
        sizeStored = newSize;
    }

    /**
     * removes all the character data from start to size-1.
     * It throws NoTextException, if there is no data to remove.
     * It should shrink the size after deleting the corresponding character data by setting it to a new capacity of capacity-size.
     * You need to check that the indices are valid or else throw an ArrayIndexOutOfBounds exception.
     * Returns true if successful.
     * This method should be O(n).
     *
     * @param start the index in textArchive from which to start removing
     * @param size  the number of elements to remove from textArchive
     * @return returns true if successful
     */
    public boolean cleanArchivedText(int start, int size) throws NoTextException {
        if (isEmpty()) {
            throw new NoTextException();
        }
        if (start < 0 || start >= sizeStored || start + size > sizeStored) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.arraycopy(textArchive, start + size, textArchive, start, sizeStored - start - size);
        sizeStored -= size;
        return true;
    }

    /**
     * maximum storage capacity of textArchive.
     *
     * @return returns the maximum storage capacity of textArchive.
     */
    public int getStorageCapacity() {
        return textArchive.length * Character.BYTES * 8;
    }

    /**
     * @return returns the size of character data inserted in the textArchive.
     */
    public int getSize() {
        return sizeStored;
    }

    /**
     * checks if the textArchive is empty.
     *
     * @return true if empty
     */
    public boolean isEmpty() {
        return sizeStored == 0;
    }

    /**
     * checks if the textArchive is full.
     *
     * @return true if textArchive is full
     */
    public boolean isFull() {
        return sizeStored == textArchive.length;
    }

    /**
     * cipherText setter method
     *
     * @param cipher to set cipherText
     */
    public void setCipherText(String cipher) {
        cipherText = cipher;
    }

    /**
     * cipherText getter method
     *
     * @return cipherText
     */
    public String getCipherText() {
        return cipherText;
    }

    /**
     * plaiText setter method
     *
     * @param plain to set plainText
     */
    public void setPlainText(String plain) {
        plainText = plain;
    }

    /**
     * plainText getter method
     *
     * @return plainText
     */
    public String getPlainText() {
        return plainText;
    }

    /**
     * sets the keys
     * set the size of keys to be 5 of 26 length cipher alphabets.
     *
     * @param keys the cipher alphabets of 26 length each
     * @param size 5 cipher alphabet keys
     */
    public void setKeys(char[][] keys, int size) {
        this.keys = new char[size][keys[0].length];
        this.keys = keys;
    }

    /**
     * this method returns a copy of textArchive array from start point to the size.
     * returns the characters of textArchive from start to size-1
     */
    public char[] getTextArchive(int start, int size) {
        if (start < 0 || start >= sizeStored || start + size > sizeStored) {
            throw new ArrayIndexOutOfBoundsException();
        }
        char[] result = new char[size];
        System.arraycopy(textArchive, start, result, 0, size);
        return result;
    }

}