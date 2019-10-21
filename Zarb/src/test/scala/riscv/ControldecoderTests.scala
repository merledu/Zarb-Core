package riscv
import chisel3._
import chisel3.iotesters.PeekPokeTester
class ControldecoderTests(c: Controldecoder) extends PeekPokeTester(c){
	poke(c.io.in_R_type,"b1".U)
	poke(c.io.in_load,"b0".U)
	poke(c.io.in_store,"b0".U)
	poke(c.io.in_branch,"b0".U)
	poke(c.io.in_I_type,"b0".U)
	poke(c.io.in_jalr,"b0".U)
	poke(c.io.in_jal,"b0".U)
	poke(c.io.in_lui,"b0".U)
	step(1)
	expect(c.io.memwrite,"b0".U)
	expect(c.io.branch,"b0".U)
	expect(c.io.memread,"b0".U)
	expect(c.io.memtoreg,"b0".U)
	expect(c.io.regwrite,"b1".U)
	expect(c.io.Aluop,"b000".U)
	expect(c.io.operand_A_sel,"b00".U)
	expect(c.io.operand_B_sel,"b0".U)
	expect(c.io.extend_sel,"b00".U)
	expect(c.io.next_PC_sel,"b00".U)
}
