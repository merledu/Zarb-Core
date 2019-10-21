package riscv
import chisel3._
import chisel3.core.SInt
class Alu extends Module{
val io=IO(new Bundle{
	val in_alucontrol=Input(UInt(5.W))
	val in_A=Input(SInt(32.W))
	val in_B=Input(SInt(32.W))
	val Aluout=Output(SInt(32.W))
	val Alubranchout=Output(UInt(1.W))
})
	
	//Add
	when(io.in_alucontrol==="b00000".U){
		io.Aluout:=io.in_A+io.in_B
	//Sll/Slli
	}.elsewhen(io.in_alucontrol==="b00001".U){
		val inputB=io.in_B(4,0)
		io.Aluout:=io.in_A<<inputB
	//Slt/Slti
	}.elsewhen(io.in_alucontrol==="b00010".U){
		when(io.in_A<io.in_B){
			io.Aluout:=1.S
		}.otherwise{
			io.Aluout:=0.S
		}
	//SltU/SltiU/Bltu
	}.elsewhen(io.in_alucontrol==="b00011".U||io.in_alucontrol==="b10110".U){
		when(io.in_A.asUInt<io.in_B.asUInt){
			io.Aluout:=1.S
		}.otherwise{
			io.Aluout:=0.S
		}	
	//Xor/Xori
	}.elsewhen(io.in_alucontrol==="b00100".U){
		io.Aluout:=io.in_A^io.in_B
	//Srl/Srli
	}.elsewhen(io.in_alucontrol==="b00101".U){
		val inputB=io.in_B(4,0)
		io.Aluout:=io.in_A>>inputB
	//Or/Ori
	}.elsewhen(io.in_alucontrol==="b00110".U){
		io.Aluout:=io.in_A|io.in_B
	//And/Andi
	}.elsewhen(io.in_alucontrol==="b00111".U){
		io.Aluout:=io.in_A&io.in_B
	//Sub
	}.elsewhen(io.in_alucontrol==="b01000".U){
		io.Aluout:=io.in_A-io.in_B
	//Sar/Sari
	}.elsewhen(io.in_alucontrol==="b01101".U){
		val inputB=io.in_B(4,0)
		io.Aluout:=io.in_A>>inputB
	//Beq
	}.elsewhen(io.in_alucontrol==="b10000".U){
		when(io.in_A===io.in_B){
			io.Aluout:=1.S
		}.otherwise{
			io.Aluout:=0.S
		}
	//Bne
	}.elsewhen(io.in_alucontrol==="b10001".U){
		when(io.in_A===io.in_B){
			io.Aluout:=0.S
		}.otherwise{
			io.Aluout:=1.S
		}
	//Blt
	}.elsewhen(io.in_alucontrol==="b10100".U){
		when(io.in_A<io.in_B){
			io.Aluout:=1.S
		}.otherwise{
			io.Aluout:=0.S
		}	
	//Bge
	}.elsewhen(io.in_alucontrol==="b10101".U){
		when(io.in_A>=io.in_B){
			io.Aluout:=1.S
		}.otherwise{
			io.Aluout:=0.S
		}	
	//BgeU
	}.elsewhen(io.in_alucontrol==="b10111".U){
		when(io.in_A.asUInt>=io.in_B.asUInt){
			io.Aluout:=1.S
		}.otherwise{
			io.Aluout:=0.S
		}
	//Jalr/Jal
	}.elsewhen(io.in_alucontrol==="b11111".U){
			io.Aluout:=io.in_A
	}.otherwise{
		io.Aluout:=DontCare
	}
	when(io.Aluout.asUInt==="h1".U && io.in_alucontrol(4,3)==="b10".U){
		io.Alubranchout:="b1".U
	}.otherwise{
		io.Alubranchout:="b0".U
	}
}
