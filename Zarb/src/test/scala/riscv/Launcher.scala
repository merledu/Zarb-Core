// See LICENSE.txt for license details.
package riscv

import chisel3.iotesters.{Driver, TesterOptionsManager}
import utils.TutorialRunner

object Launcher {
  val examples = Map(    
	"Or" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Or(), manager) {
          (c) => new OrTests(c)
        }
     },
	"Nand" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Nand(), manager) {
          (c) => new NandTests(c)
        }
     },
	"Nor" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Nor(), manager) {
          (c) => new NorTests(c)
        }
     },
	"Xor" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Xor(), manager) {
          (c) => new XorTests(c)
        }
     },
	"Xnor" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Xnor(), manager) {
          (c) => new XnorTests(c)
        }
     },
	"Mux" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Mux(), manager) {
          (c) => new MuxTests(c)
        }
     },
	"Mux4" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Mux4(), manager) {
          (c) => new Mux4Tests(c)
        }
     },
	"Fulladder" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Fulladder(), manager) {
          (c) => new FulladderTests(c)
        }
     },
	"Fulladder2" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Fulladder2(), manager) {
          (c) => new Fulladder2Tests(c)
        }
     },
	"Fulladder4" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Fulladder4(), manager) {
          (c) => new Fulladder4Tests(c)
        }
     },
	"Alucontrol" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Alucontrol(), manager) {
          (c) => new AlucontrolTests(c)
        }
     },	
	"Immediategeneration" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Immediategeneration(), manager) {
          (c) => new ImmediategenerationTests(c)
        }
     },	
	"Typedecoder" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Typedecoder(), manager) {
          (c) => new TypedecoderTests(c)
        }
     },
	"Controldecoder" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Controldecoder(), manager) {
          (c) => new ControldecoderTests(c)
        }
     },
	"Control" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Control(), manager) {
          (c) => new ControlTests(c)
        }
     },	
	"Alu" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Alu(), manager) {
          (c) => new AluTests(c)
        }
     },
	"Registerfile" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Registerfile(), manager) {
          (c) => new RegisterfileTests(c)
        }
     },
	"Top" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Top(), manager) {
          (c) => new TopTests(c)
        }
     },
	"PC" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new PC(), manager) {
          (c) => new PCTests(c)
        }
     },
	"Instructionmemory" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Instructionmemory(), manager) {
          (c) => new InstructionmemoryTests(c)
        }
     },
	"Jalrtarget" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Jalrtarget(), manager) {
          (c) => new JalrtargetTests(c)
        }
     },	
	"Datamemory" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Datamemory(), manager) {
          (c) => new DatamemoryTests(c)
        }
     }
	
						
  )
  def main(args: Array[String]): Unit = {
    TutorialRunner("examples", examples, args)
  }
}

