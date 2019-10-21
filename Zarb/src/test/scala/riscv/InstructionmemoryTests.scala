package riscv
import chisel3.iotesters.PeekPokeTester
class InstructionmemoryTests(c:Instructionmemory) extends PeekPokeTester(c){
	poke(c.io.wrAddr,2)
	step(1)
}
