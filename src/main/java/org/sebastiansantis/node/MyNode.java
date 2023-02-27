package org.sebastiansantis.node;

import lombok.Data;
import org.sebastiansantis.utils.Hash;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Logger;

@Data
public class MyNode<E> {

    /* | ---------------------------------- + Utilities + ---------------------------------- | */
    private final Random random = new Random();
    private static final Logger LOG = Logger.getLogger("MyNode.class");

    /* | ---------------------------------- + Attributes + ---------------------------------- | */

    private String code;
    private Integer numberInList;
    private E item;
    private MyNode<E> next;
    private MyNode<E> prev;

    /* | ---------------------------------- + Constructor + ---------------------------------- | */

    public MyNode(E element) {

        final int randomNumber = random.nextInt(900000000) + 100000000;
        final byte[] salt = Hash.generateSalt();

        try{
            final byte[] hash = Hash.generateHash(Integer.toString(randomNumber), salt);
            this.code = Hash.bytesToHex(hash);
        }catch (NoSuchAlgorithmException error){
            LOG.info(()->"Error: " + error);
        }

        this.numberInList = 0;
        this.item = element;
        this.next = null;
        this.prev = null;

    }


}
