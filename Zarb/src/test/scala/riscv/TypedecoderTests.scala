package riscv
import chisel3._
import chisel3.iotesters.PeekPokeTester
class TypedecoderTests(c: Typedecoder) extends PeekPokeTester(c){
	poke(c.io.opcode,"h33".U)
	step(1)
	expect(c.io.R_type,"b1".U)
	expect(c.io.load,"b0".U)
	expect(c.io.store,"b0".U)
	expect(c.io.branch,"b0".U)
	expect(c.io.I_type,"b0".U)
	expect(c.io.jalr,"b0".U)
	expect(c.io.jal,"b0".U)
	expect(c.io.lui,"b0".U)
}
