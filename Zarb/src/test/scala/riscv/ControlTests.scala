package riscv
import chisel3._
import chisel3.iotesters.PeekPokeTester
class ControlTests(c: Control) extends PeekPokeTester(c){
	poke(c.io.in_opcode,"h33".U)
	step(1)
	expect(c.io.out_memwrite,"b0".U)
	expect(c.io.out_branch,"b0".U)
	expect(c.io.out_memread,"b0".U)
	expect(c.io.out_memtoreg,"b0".U)
	expect(c.io.out_regwrite,"b1".U)
	expect(c.io.out_Aluop,"b000".U)
	expect(c.io.out_operand_A_sel,"b00".U)
	expect(c.io.out_operand_B_sel,"b0".U)
	expect(c.io.out_extend_sel,"b00".U)
	expect(c.io.out_next_PC_sel,"b00".U)
}
