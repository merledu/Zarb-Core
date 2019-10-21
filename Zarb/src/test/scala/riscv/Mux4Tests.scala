package riscv
import chisel3.iotesters.PeekPokeTester
class Mux4Tests(c: Mux4) extends PeekPokeTester(c){
	poke(c.io.in0,0)
	poke(c.io.in1,0)
	poke(c.io.in2,0)
	poke(c.io.in3,0)
	poke(c.io.sl0,0)
	poke(c.io.sl1,0)
	step(1)
	expect(c.io.out,0)
}
