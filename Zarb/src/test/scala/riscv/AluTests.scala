package riscv
import chisel3._
import chisel3.iotesters.PeekPokeTester
class AluTests(c: Alu) extends PeekPokeTester(c){
	poke(c.io.in_A,2)
	poke(c.io.in_B,3)
	poke(c.io.in_alucontrol,3)
	step(1)
	expect(c.io.Alubranchout,0)
	expect(c.io.Aluout,1)
}
