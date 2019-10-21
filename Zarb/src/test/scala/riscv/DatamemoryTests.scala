package riscv
import chisel3._
import chisel3.iotesters.PeekPokeTester
class DatamemoryTests(c: Datamemory) extends PeekPokeTester(c){
	poke(c.io.in_Aluoutput,0)
	poke(c.io.in_rs2out,10)
	poke(c.io.in_controlmemwrite,1)
	poke(c.io.in_controlmemread,0)
	step(1)
}
