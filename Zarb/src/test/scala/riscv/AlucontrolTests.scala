package riscv
import chisel3.iotesters.PeekPokeTester
class AlucontrolTests(c: Alucontrol) extends PeekPokeTester(c){
	poke(c.io.aluop,0)
	poke(c.io.funct3,0)
	poke(c.io.funct7,0)
	step(1)
	expect(c.io.alucontoutput,0)
}
