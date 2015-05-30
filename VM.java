package vm;

import static vm.ByteCode.BR;
import static vm.ByteCode.BRF;
import static vm.ByteCode.BRT;
import static vm.ByteCode.CALL;
import static vm.ByteCode.GLOAD;
import static vm.ByteCode.GSTORE;
import static vm.ByteCode.HALT;
import static vm.ByteCode.IADD;
import static vm.ByteCode.ICONST;
import static vm.ByteCode.IEQ;
import static vm.ByteCode.ILT;
import static vm.ByteCode.IMUL;
import static vm.ByteCode.ISUB;
import static vm.ByteCode.LOAD;
import static vm.ByteCode.POP;
import static vm.ByteCode.PRINT;
import static vm.ByteCode.RET;
import static vm.ByteCode.STORE;

public class VM {

    public static final int DEFAULT_STACK_SIZE = 1000;
    public static final int DEFAULT_CALL_STACK_SIZE = 1000;
    public static final int FALSE = 0;
    public static final int TRUE  = 1;

    //registers
    int ip;             // instruction pointer register
    int sp = -1;        // stack pointer register

    //memory
    int[] code;         // word-addressable code memory but still bytecodes
    int[] globals;      // global variable space
    int[] stack;        // Operand stack, grows upwards
    //Context ctx;        // the active context

    /** Metadata about the function allows us to refer to function by
     *  their index in this table. It makes code generation easier for
     *  the bytecode compiler because it doesn't have to resolve addresses
     *  for forward references. It can generate simply "CALL i" where i is
     *  the index of the function. Later, the compiler can store the function
     *  address in the metadata table when the code is generated for that function
     */
    FuncMetaData[] metadata;

    public VM(int[] code, int nglobals, FuncMetaData[] metadata)
    {
        this.code = code;
        globals = new int[nglobals];
        stack  = new int[DEFAULT_STACK_SIZE];
        this.metadata = metadata;
    }

    public void exec(int startup)
    {
        ip = startip;
        ctx = new Context(null, 0, metadata[0]);
        cpu();
    }

    /** Simulate the fetch-decode execute cycle */
    protected void cpu()
    {
        int opcode = code[ip];
        int a,b,addr, regnum;
        while(opcode != HALT && ip < code.length)
        {
            if(trace) System.err.printf("%-35s", disInstr());
            ip++;   //jump to next instruction or to operand
            switch(opcode)
            {
                case IADD:
                    b = stack[sp--];
                    a = stack[sp--];
                    stack[++stack] = a + b;
                    break;
            }
        }
    }
}
