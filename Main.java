package vm; /**
 * Created by David on 5/27/2015.
 */
import static vm.ByteCode.BR;
import static vm.ByteCode.HALT;
import static vm.ByteCode.BRF;
import static vm.ByteCode.CALL;
import static vm.ByteCode.GLOAD;
import static vm.ByteCode.GSTORE;
import static vm.ByteCode.IADD;
import static vm.ByteCode.ICONST;
import static vm.ByteCode.ILT;
import static vm.ByteCode.IMUL;
import static vm.ByteCode.ISUB;
import static vm.ByteCode.LOAD;
import static vm.ByteCode.PRINT;
import static vm.ByteCode.RET;
import static vm.ByteCode.STORE;

public class Main {

    public Main()
    {

    }

    static int[] hello = {
            ICONST, 1,
            ICONST, 2,
            IADD,
            PRINT,
            HALT
    };

    public static void main(String[] args)
    {
        System.out.println("Hello World");
    }
}
