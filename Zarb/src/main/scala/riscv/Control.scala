package riscv
import chisel3._
class Control extends Module{
val io=IO(new Bundle{
	val in_opcode=Input(UInt(7.W))
	val out_memwrite=Output(UInt(1.W))
	val out_branch=Output(UInt(1.W))
	val out_memread=Output(UInt(1.W))
	val out_regwrite=Output(UInt(1.W))
	val out_memtoreg=Output(UInt(1.W))
	val out_Aluop=Output(UInt(3.W))
	val out_operand_A_sel=Output(UInt(2.W))
	val out_operand_B_sel=Output(UInt(1.W))
	val out_extend_sel=Output(UInt(2.W))
	val out_next_PC_sel=Output(UInt(2.W))
})
	val type_decoder=Module(new Typedecoder)
	val control_decoder=Module(new Controldecoder)
	type_decoder.io.opcode:=io.in_opcode
	control_decoder.io.in_R_type:=type_decoder.io.R_type
	control_decoder.io.in_load:=type_decoder.io.load
	control_decoder.io.in_store:=type_decoder.io.store
	control_decoder.io.in_branch:=type_decoder.io.branch
	control_decoder.io.in_I_type:=type_decoder.io.I_type
	control_decoder.io.in_jalr:=type_decoder.io.jalr
	control_decoder.io.in_jal:=type_decoder.io.jal
	control_decoder.io.in_lui:=type_decoder.io.lui
	io.out_memwrite:=control_decoder.io.memwrite
	io.out_branch:=control_decoder.io.branch
	io.out_memread:=control_decoder.io.memread
	io.out_regwrite:=control_decoder.io.regwrite
	io.out_memtoreg:=control_decoder.io.memtoreg
	io.out_Aluop:=control_decoder.io.Aluop
	io.out_operand_A_sel:=control_decoder.io.operand_A_sel
	io.out_operand_B_sel:=control_decoder.io.operand_B_sel
	io.out_extend_sel:=control_decoder.io.extend_sel
	io.out_next_PC_sel:=control_decoder.io.next_PC_sel
}
