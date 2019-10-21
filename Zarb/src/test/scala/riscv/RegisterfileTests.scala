package riscv
import chisel3.iotesters.PeekPokeTester
class RegisterfileTests(c:Registerfile) extends PeekPokeTester(c){
		poke(c.io.in_rs1,3)
		poke(c.io.in_rs2,2)
		poke(c.io.in_regwrite,1)
		poke(c.io.in_rd,4)
		poke(c.io.in_writedata,4)
		step(1)
		expect(c.io.out_rs1,0)
		expect(c.io.out_rs2,0)
}
