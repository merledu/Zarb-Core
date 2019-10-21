package riscv
import chisel3.iotesters.PeekPokeTester
class MuxTests(c: Mux) extends PeekPokeTester(c){
	poke(c.io.i0,0)
	poke(c.io.i1,0)
	poke(c.io.s0,0)
	step(1)
	expect(c.io.o,0)
}
