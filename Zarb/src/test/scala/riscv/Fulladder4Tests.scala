package riscv
import chisel3.iotesters.PeekPokeTester
class Fulladder4Tests(c:Fulladder4) extends PeekPokeTester(c){
 poke(c.io.c0,0)
 poke(c.io.c1,0)
 poke(c.io.d0,0)
 poke(c.io.d1,0)
 poke(c.io.cin2,0)
 step(1)
 expect(c.io.sum2,0)
 expect(c.io.sum3,0)
 expect(c.io.cout2,0)
}
