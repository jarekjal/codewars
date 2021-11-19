package jarekjal.codewars.kyu3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD development by writing your own tests

public class RailFenceCipherTest {

    @Test
    public void encodeSampleTests() {
        String[][] encodes = {{"WEAREDISCOVEREDFLEEATONCE", "WECRLTEERDSOEEFEAOCAIVDEN"},  // 3 rails
                {"Hello, World!", "Hoo!el,Wrdl l"},    // 3 rails
                {"Hello, World!", "H !e,Wdloollr"},    // 4 rails
                {"", ""}     ,
                {"WEAREDISCOVEREDFLEEATONCE", "WDEEFARLREEEVEEDOACICTNSO"}// 3 rails (even if...)
        };
        int[] rails = {3, 3, 4, 3, 8};
        for (int i = 0; i < encodes.length; i++) {
            Assert.assertEquals(encodes[i][1], RailFenceCipher.encode(encodes[i][0], rails[i]));
        }
    }


    @Test
    public void decodeSampleTests() {
        String[][] decodes = {
                {"WECRLTEERDSOEEFEAOCAIVDEN", "WEAREDISCOVEREDFLEEATONCE"},    // 3 rails
                {"H !e,Wdloollr", "Hello, World!"},    // 4 rails
                {"", ""},                               // 3 rails (even if...)
                {"Amet non facere minima iure unde, provident, veritatis officiis asperiores ipsa eveniet sit! Deserunt autem excepturi quibusdam iure unde! Porro alias distinctio ipsam iure exercitationem molestiae. Voluptate fugiat quasi maiores!jk",
                        "An aplsdmeiitat,e !sa  ptrDdtieo vsseteindri nueonncftttn, iuoa  vu gitefrepismiat aameactx ticieseu rp roteq ufefreuxii c earqimiucsiisi btiauansst idpieaomnmrmi eamioaru imre seool  iiuersnpusdteiear !ase eevP.! oe nrVjoriueolku t"},
                {"ABC", "ABC"},
                {"ACB", "ABC"},
                {"WEAREDISCOVEREDFLEEATONCE", "WADCEFACTLROIREESVEEOENED"}

        };
        int[] rails = {3, 4, 3, 5, 6, 2, 8};
        for (int i = 0; i < decodes.length; i++) {
            assertEquals(decodes[i][1], RailFenceCipher.decode(decodes[i][0], rails[i]));
        }
    }


}

