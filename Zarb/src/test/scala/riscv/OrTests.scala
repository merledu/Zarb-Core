package riscv
import chisel3.iotesters.PeekPokeTester
class OrTests(c : Or) extends PeekPokeTester(c) {
	poke(c.io.a, 1)
	poke(c.io.b, 1)
	step(1)
	expect(c.io.o,1)
}
