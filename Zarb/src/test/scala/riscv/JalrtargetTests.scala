package riscv
import chisel3._
import chisel3.iotesters.PeekPokeTester
class JalrtargetTests(c:Jalrtarget) extends PeekPokeTester(c){
	poke(c.io.in_rs1out,2)
	poke(c.io.in_immed,2)
	step(1)
}

