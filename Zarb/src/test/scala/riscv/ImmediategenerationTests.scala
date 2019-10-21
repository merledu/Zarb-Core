package riscv
import chisel3.iotesters.PeekPokeTester
class ImmediategenerationTests(c: Immediategeneration) extends PeekPokeTester(c){
		poke(c.io.instruction,1048576)
		poke(c.io.pc,0)
		step(1)
		expect(c.io.sb_type,0)
		expect(c.io.s_type,0)
		expect(c.io.u_type,1048576)
		expect(c.io.uj_type,2048)
		expect(c.io.i_type,1)		
}
