package riscv
import chisel3.iotesters.PeekPokeTester
class Fulladder2Tests(c:Fulladder2) extends PeekPokeTester(c){
 poke(c.io.a0,1)
 poke(c.io.a1,1)
 poke(c.io.b0,1)
 poke(c.io.b1,1)
 poke(c.io.cin0,1)
 step(1)
 expect(c.io.sum0,1)
 expect(c.io.sum1,1)
 expect(c.io.cout1,1)
}
