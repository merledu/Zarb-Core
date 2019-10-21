package riscv
import chisel3._
class Controldecoder extends Module{
val io=IO(new Bundle{
	val in_R_type=Input(UInt(1.W))
	val in_load=Input(UInt(1.W))
	val in_store=Input(UInt(1.W))
	val in_branch=Input(UInt(1.W))
	val in_I_type=Input(UInt(1.W))
	val in_jalr=Input(UInt(1.W))
	val in_jal=Input(UInt(1.W))
	val in_lui=Input(UInt(1.W))
	val memwrite=Output(UInt(1.W))
	val branch=Output(UInt(1.W))
	val memread=Output(UInt(1.W))
	val regwrite=Output(UInt(1.W))
	val memtoreg=Output(UInt(1.W))
	val Aluop=Output(UInt(3.W))
	val operand_A_sel=Output(UInt(2.W))
	val operand_B_sel=Output(UInt(1.W))
	val extend_sel=Output(UInt(2.W))
	val next_PC_sel=Output(UInt(2.W))
})
	when(io.in_R_type==="b1".U){
		io.memwrite:="b0".U
		io.branch:="b0".U
		io.memread:="b0".U
		io.memtoreg:="b0".U
		io.regwrite:="b1".U
		io.Aluop:="b000".U
		io.operand_A_sel:="b00".U
		io.operand_B_sel:="b0".U
		io.extend_sel:="b00".U
		io.next_PC_sel:="b00".U
	}.elsewhen(io.in_load==="b1".U){
		io.memwrite:="b0".U
		io.branch:="b0".U
		io.memread:="b1".U
		io.memtoreg:="b1".U
		io.regwrite:="b1".U
		io.Aluop:="b100".U
		io.operand_A_sel:="b00".U
		io.operand_B_sel:="b1".U
		io.extend_sel:="b00".U
		io.next_PC_sel:="b00".U
	}.elsewhen(io.in_store==="b1".U){
		io.memwrite:="b1".U
		io.branch:="b0".U
		io.memread:="b0".U
		io.memtoreg:="b0".U
		io.regwrite:="b0".U
		io.Aluop:="b101".U
		io.operand_A_sel:="b00".U
		io.operand_B_sel:="b1".U
		io.extend_sel:="b10".U
		io.next_PC_sel:="b00".U
	}.elsewhen(io.in_branch==="b1".U){
		io.memwrite:="b0".U
		io.branch:="b1".U
		io.memread:="b0".U
		io.memtoreg:="b0".U
		io.regwrite:="b0".U
		io.Aluop:="b010".U
		io.operand_A_sel:="b00".U
		io.operand_B_sel:="b0".U
		io.extend_sel:="b00".U
		io.next_PC_sel:="b01".U
	}.elsewhen(io.in_I_type==="b1".U){
		io.memwrite:="b0".U
		io.branch:="b0".U
		io.memread:="b0".U
		io.memtoreg:="b0".U
		io.regwrite:="b1".U
		io.Aluop:="b001".U
		io.operand_A_sel:="b00".U
		io.operand_B_sel:="b1".U
		io.extend_sel:="b00".U
		io.next_PC_sel:="b00".U
	}.elsewhen(io.in_jalr==="b1".U){
		io.memwrite:="b0".U
		io.branch:="b0".U
		io.memread:="b0".U
		io.memtoreg:="b0".U
		io.regwrite:="b1".U
		io.Aluop:="b011".U
		io.operand_A_sel:="b10".U
		io.operand_B_sel:="b0".U
		io.extend_sel:="b00".U
		io.next_PC_sel:="b11".U
	}.elsewhen(io.in_jal==="b1".U){
		io.memwrite:="b0".U
		io.branch:="b0".U
		io.memread:="b0".U
		io.memtoreg:="b0".U
		io.regwrite:="b1".U
		io.Aluop:="b011".U
		io.operand_A_sel:="b10".U
		io.operand_B_sel:="b0".U
		io.extend_sel:="b00".U
		io.next_PC_sel:="b10".U
	}.elsewhen(io.in_lui==="b1".U){
		io.memwrite:="b0".U
		io.branch:="b0".U
		io.memread:="b0".U
		io.memtoreg:="b0".U
		io.regwrite:="b1".U
		io.Aluop:="b110".U
		io.operand_A_sel:="b11".U
		io.operand_B_sel:="b1".U
		io.extend_sel:="b01".U
		io.next_PC_sel:="b00".U
	}.otherwise{
		io.memwrite:=DontCare
		io.branch:=DontCare
		io.memread:=DontCare
		io.memtoreg:=DontCare
		io.regwrite:=DontCare
		io.Aluop:=DontCare
		io.operand_A_sel:=DontCare
		io.operand_B_sel:=DontCare
		io.extend_sel:=DontCare
		io.next_PC_sel:=DontCare
	}	
}
