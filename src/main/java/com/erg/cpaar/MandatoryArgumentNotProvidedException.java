package com.erg.cpaar;


/**
 * Thrown when a mandatory argument is not provided.
 */
public class MandatoryArgumentNotProvidedException extends BaseGeneralException {
    /**
     * Creates an instance of MandatoryArgumentNotProvidedException
     * @param whatHappened
     * @param endGame
     * @param causeReference
     * @param resultReference
     */
    public MandatoryArgumentNotProvidedException(String whatHappened, Boolean endGame, String causeReference, String resultReference) {
        super(whatHappened, endGame, causeReference, resultReference);
    }
}
