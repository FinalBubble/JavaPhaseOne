package Test;

import java.math.BigInteger;


/**
 * @author yangq
 * @date 2023-03-31
 * @Project Phase one
 * @Package Test
 * @Description TODO
 */
public class Demo1 {
    public static void main(String[] args) {
        BigInteger n = new BigInteger("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123",16);
        //根据公式 r = ( e + x1 ) mod n 求证两次签名的x1是否相等，证明参与签名的随机数相等
        BigInteger r11 = new BigInteger("1260185C3D7437E6A63F1E18FD810A314A5E27D67884A83F1283D72F1009F699",16);
        BigInteger s11 = new BigInteger("0E9F423B578A8707C83C1A0A3982F52D0FF718C2B481966E4D839CD566EE7209",16);
        BigInteger e11 = new BigInteger("875817FFC25231A88B68696273AEECE852A10CCDE93C19476482EBA4D4877322",16);

        BigInteger x11 = (r11.subtract(e11).mod(n));
        System.out.println("x11 = (r11 - e11) mod n ="+x11.toString(16).toUpperCase());

        BigInteger e12 = new BigInteger("8FB2B63B9CF9ED7842CC0E0A204B36A3ED5C45936B6148646A26915120F6C7D2",16);
        BigInteger r12 = new BigInteger("1ABAB698181BF3B65DA2C2C0AA1D53ECE519609BFAA9D75C18277CDB5C794B49",16);
        BigInteger s12 = new BigInteger("EBB541CA42C5CCA5FA1324DDC32D3F352546FE4EECE8034E1D64A2848E2A93B9",16);

        BigInteger x12 = (r12.subtract(e12).mod(n));
        System.out.println("x12 = (r12 - e12) mod n ="+x12.toString(16).toUpperCase());
        System.out.println(x11.subtract(x12));
        if (x12.compareTo(x11) == 0){
            System.out.println("两次签名的随机数相等!");
        }else {
            System.out.println("两次签名的随机数不相等!");
            return;
        }
        //根据签名公式 s = ( 1 + d ) ^ -1 * ( k + r * d ) mod n 已知s和r，且k相等，求解d
        // s12 = ( 1 + d ) ^ -1 * ( k - r12 * d ) mod n
        // s11 = ( 1 + d ) ^ -1 * ( k - r11 * d ) mod n
        // k = ( s12 *  ( 1 + d ) + r12 * d ) mod n
        // k = ( s11 *  ( 1 + d ) + r11 * d ) mod n
        // ( s11 *  ( 1 + d ) + r11 * d ) mod n = ( s12 *  ( 1 + d ) + r12 * d ) mod n
        // ( s11 + r11 - s12 - r12 ) * d = s12 - s11
        // d = ( s12 - s11 ) * ( s11 + r11 - s12 - r12 ) ^ -1 mod n
        BigInteger d = (s12.subtract(s11)).
                multiply(
                        (s11.add(r11).subtract(s12).subtract(r12)).
                                modInverse(n)).mod(n);
        System.out.println("求解的私钥为："+d.toString(16));

    }



}
