import { Chess } from '../src/chess'

describe('History', () => {
  const chess = new Chess()
  const tests = [
    {
      verbose: false,
      fen: '4q2k/2r1r3/4PR1p/p1p5/P1Bp1Q1P/1P6/6P1/6K1 b - - 4 41',
      moves: [
        'c4',
        'e6',
        'Nf3',
        'd5',
        'd4',
        'Nf6',
        'Nc3',
        'Be7',
        'Bg5',
        'O-O',
        'e3',
        'h6',
        'Bh4',
        'b6',
        'cxd5',
        'Nxd5',
        'Bxe7',
        'Qxe7',
        'Nxd5',
        'exd5',
        'Rc1',
        'Be6',
        'Qa4',
        'c5',
        'Qa3',
        'Rc8',
        'Bb5',
        'a6',
        'dxc5',
        'bxc5',
        'O-O',
        'Ra7',
        'Be2',
        'Nd7',
        'Nd4',
        'Qf8',
        'Nxe6',
        'fxe6',
        'e4',
        'd4',
        'f4',
        'Qe7',
        'e5',
        'Rb8',
        'Bc4',
        'Kh8',
        'Qh3',
        'Nf8',
        'b3',
        'a5',
        'f5',
        'exf5',
        'Rxf5',
        'Nh7',
        'Rcf1',
        'Qd8',
        'Qg3',
        'Re7',
        'h4',
        'Rbb7',
        'e6',
        'Rbc7',
        'Qe5',
        'Qe8',
        'a4',
        'Qd8',
        'R1f2',
        'Qe8',
        'R2f3',
        'Qd8',
        'Bd3',
        'Qe8',
        'Qe4',
        'Nf6',
        'Rxf6',
        'gxf6',
        'Rxf6',
        'Kg8',
        'Bc4',
        'Kh8',
        'Qf4',
      ],
    },
    {
      verbose: true,
      fen: '4q2k/2r1r3/4PR1p/p1p5/P1Bp1Q1P/1P6/6P1/6K1 b - - 4 41',
      moves: [
        {
          color: 'w',
          piece: 'p',
          from: 'c2',
          to: 'c4',
          flags: 'b',
          san: 'c4',
          lan: 'c2c4',
          before: 'rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1',
          after: 'rnbqkbnr/pppppppp/8/8/2P5/8/PP1PPPPP/RNBQKBNR b KQkq - 0 1',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'e7',
          to: 'e6',
          flags: 'n',
          san: 'e6',
          lan: 'e7e6',
          before: 'rnbqkbnr/pppppppp/8/8/2P5/8/PP1PPPPP/RNBQKBNR b KQkq - 0 1',
          after: 'rnbqkbnr/pppp1ppp/4p3/8/2P5/8/PP1PPPPP/RNBQKBNR w KQkq - 0 2',
        },
        {
          color: 'w',
          piece: 'n',
          from: 'g1',
          to: 'f3',
          flags: 'n',
          san: 'Nf3',
          lan: 'g1f3',
          before:
            'rnbqkbnr/pppp1ppp/4p3/8/2P5/8/PP1PPPPP/RNBQKBNR w KQkq - 0 2',
          after:
            'rnbqkbnr/pppp1ppp/4p3/8/2P5/5N2/PP1PPPPP/rnbqkbnr b KQkq - 1 2',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'd7',
          to: 'd5',
          flags: 'b',
          san: 'd5',
          lan: 'd7d5',
          before:
            'rnbqkbnr/pppp1ppp/4p3/8/2P5/5N2/PP1PPPPP/rnbqkbnr b KQkq - 1 2',
          after:
            'rnbqkbnr/ppp2ppp/4p3/3p4/2P5/5N2/PP1PPPPP/rnbqkbnr w KQkq - 0 3',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'd2',
          to: 'd4',
          flags: 'b',
          san: 'd4',
          lan: 'd2d4',
          before:
            'rnbqkbnr/ppp2ppp/4p3/3p4/2P5/5N2/PP1PPPPP/rnbqkbnr w KQkq - 0 3',
          after:
            'rnbqkbnr/ppp2ppp/4p3/3p4/2PP4/5N2/PP2PPPP/rnbqkbnr b KQkq - 0 3',
        },
        {
          color: 'b',
          piece: 'n',
          from: 'g8',
          to: 'f6',
          flags: 'n',
          san: 'Nf6',
          lan: 'g8f6',
          before:
            'rnbqkbnr/ppp2ppp/4p3/3p4/2PP4/5N2/PP2PPPP/rnbqkbnr b KQkq - 0 3',
          after:
            'rnbqkbnr/ppp2ppp/4pn2/3p4/2PP4/5N2/PP2PPPP/rnbqkbnr w KQkq - 1 4',
        },
        {
          color: 'w',
          piece: 'n',
          from: 'b1',
          to: 'c3',
          flags: 'n',
          san: 'Nc3',
          lan: 'b1c3',
          before:
            'rnbqkbnr/ppp2ppp/4pn2/3p4/2PP4/5N2/PP2PPPP/rnbqkbnr w KQkq - 1 4',
          after:
            'rnbqkbnr/ppp2ppp/4pn2/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R b KQkq - 2 4',
        },
        {
          color: 'b',
          piece: 'b',
          from: 'f8',
          to: 'e7',
          flags: 'n',
          san: 'Be7',
          lan: 'f8e7',
          before:
            'rnbqkbnr/ppp2ppp/4pn2/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R b KQkq - 2 4',
          after:
            'rnbqk2r/ppp1bppp/4pn2/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R w KQkq - 3 5',
        },
        {
          color: 'w',
          piece: 'b',
          from: 'c1',
          to: 'g5',
          flags: 'n',
          san: 'Bg5',
          lan: 'c1g5',
          before:
            'rnbqk2r/ppp1bppp/4pn2/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R w KQkq - 3 5',
          after:
            'rnbqk2r/ppp1bppp/4pn2/3p2B1/2PP4/2N2N2/PP2PPPP/R2QKB1R b KQkq - 4 5',
        },
        {
          color: 'b',
          piece: 'k',
          from: 'e8',
          to: 'g8',
          flags: 'k',
          san: 'O-O',
          lan: 'e8g8',
          before:
            'rnbqk2r/ppp1bppp/4pn2/3p2B1/2PP4/2N2N2/PP2PPPP/R2QKB1R b KQkq - 4 5',
          after:
            'rnbq1rk1/ppp1bppp/4pn2/3p2B1/2PP4/2N2N2/PP2PPPP/R2QKB1R w KQ - 5 6',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'e2',
          to: 'e3',
          flags: 'n',
          san: 'e3',
          lan: 'e2e3',
          before:
            'rnbq1rk1/ppp1bppp/4pn2/3p2B1/2PP4/2N2N2/PP2PPPP/R2QKB1R w KQ - 5 6',
          after:
            'rnbq1rk1/ppp1bppp/4pn2/3p2B1/2PP4/2N1PN2/PP3PPP/R2QKB1R b KQ - 0 6',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'h7',
          to: 'h6',
          flags: 'n',
          san: 'h6',
          lan: 'h7h6',
          before:
            'rnbq1rk1/ppp1bppp/4pn2/3p2B1/2PP4/2N1PN2/PP3PPP/R2QKB1R b KQ - 0 6',
          after:
            'rnbq1rk1/ppp1bpp1/4pn1p/3p2B1/2PP4/2N1PN2/PP3PPP/R2QKB1R w KQ - 0 7',
        },
        {
          color: 'w',
          piece: 'b',
          from: 'g5',
          to: 'h4',
          flags: 'n',
          san: 'Bh4',
          lan: 'g5h4',
          before:
            'rnbq1rk1/ppp1bpp1/4pn1p/3p2B1/2PP4/2N1PN2/PP3PPP/R2QKB1R w KQ - 0 7',
          after:
            'rnbq1rk1/ppp1bpp1/4pn1p/3p4/2PP3B/2N1PN2/PP3PPP/R2QKB1R b KQ - 1 7',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'b7',
          to: 'b6',
          flags: 'n',
          san: 'b6',
          lan: 'b7b6',
          before:
            'rnbq1rk1/ppp1bpp1/4pn1p/3p4/2PP3B/2N1PN2/PP3PPP/R2QKB1R b KQ - 1 7',
          after:
            'rnbq1rk1/p1p1bpp1/1p2pn1p/3p4/2PP3B/2N1PN2/PP3PPP/R2QKB1R w KQ - 0 8',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'c4',
          to: 'd5',
          flags: 'c',
          san: 'cxd5',
          lan: 'c4d5',
          before:
            'rnbq1rk1/p1p1bpp1/1p2pn1p/3p4/2PP3B/2N1PN2/PP3PPP/R2QKB1R w KQ - 0 8',
          captured: 'p',
          after:
            'rnbq1rk1/p1p1bpp1/1p2pn1p/3P4/3P3B/2N1PN2/PP3PPP/R2QKB1R b KQ - 0 8',
        },
        {
          color: 'b',
          piece: 'n',
          from: 'f6',
          to: 'd5',
          flags: 'c',
          san: 'Nxd5',
          lan: 'f6d5',
          before:
            'rnbq1rk1/p1p1bpp1/1p2pn1p/3P4/3P3B/2N1PN2/PP3PPP/R2QKB1R b KQ - 0 8',
          captured: 'p',
          after:
            'rnbq1rk1/p1p1bpp1/1p2p2p/3n4/3P3B/2N1PN2/PP3PPP/R2QKB1R w KQ - 0 9',
        },
        {
          color: 'w',
          piece: 'b',
          from: 'h4',
          to: 'e7',
          flags: 'c',
          san: 'Bxe7',
          lan: 'h4e7',
          before:
            'rnbq1rk1/p1p1bpp1/1p2p2p/3n4/3P3B/2N1PN2/PP3PPP/R2QKB1R w KQ - 0 9',
          captured: 'b',
          after:
            'rnbq1rk1/p1p1Bpp1/1p2p2p/3n4/3P4/2N1PN2/PP3PPP/R2QKB1R b KQ - 0 9',
        },
        {
          color: 'b',
          piece: 'q',
          from: 'd8',
          to: 'e7',
          flags: 'c',
          san: 'Qxe7',
          lan: 'd8e7',
          before:
            'rnbq1rk1/p1p1Bpp1/1p2p2p/3n4/3P4/2N1PN2/PP3PPP/R2QKB1R b KQ - 0 9',
          captured: 'b',
          after:
            'rnb2rk1/p1p1qpp1/1p2p2p/3n4/3P4/2N1PN2/PP3PPP/R2QKB1R w KQ - 0 10',
        },
        {
          color: 'w',
          piece: 'n',
          from: 'c3',
          to: 'd5',
          flags: 'c',
          san: 'Nxd5',
          lan: 'c3d5',
          before:
            'rnb2rk1/p1p1qpp1/1p2p2p/3n4/3P4/2N1PN2/PP3PPP/R2QKB1R w KQ - 0 10',
          captured: 'n',
          after:
            'rnb2rk1/p1p1qpp1/1p2p2p/3N4/3P4/4PN2/PP3PPP/R2QKB1R b KQ - 0 10',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'e6',
          to: 'd5',
          flags: 'c',
          san: 'exd5',
          lan: 'e6d5',
          before:
            'rnb2rk1/p1p1qpp1/1p2p2p/3N4/3P4/4PN2/PP3PPP/R2QKB1R b KQ - 0 10',
          captured: 'n',
          after:
            'rnb2rk1/p1p1qpp1/1p5p/3p4/3P4/4PN2/PP3PPP/R2QKB1R w KQ - 0 11',
        },
        {
          color: 'w',
          piece: 'r',
          from: 'a1',
          to: 'c1',
          flags: 'n',
          san: 'Rc1',
          lan: 'a1c1',
          before:
            'rnb2rk1/p1p1qpp1/1p5p/3p4/3P4/4PN2/PP3PPP/R2QKB1R w KQ - 0 11',
          after: 'rnb2rk1/p1p1qpp1/1p5p/3p4/3P4/4PN2/PP3PPP/2RQKB1R b K - 1 11',
        },
        {
          color: 'b',
          piece: 'b',
          from: 'c8',
          to: 'e6',
          flags: 'n',
          san: 'Be6',
          lan: 'c8e6',
          before:
            'rnb2rk1/p1p1qpp1/1p5p/3p4/3P4/4PN2/PP3PPP/2RQKB1R b K - 1 11',
          after:
            'rn3rk1/p1p1qpp1/1p2b2p/3p4/3P4/4PN2/PP3PPP/2RQKB1R w K - 2 12',
        },
        {
          color: 'w',
          piece: 'q',
          from: 'd1',
          to: 'a4',
          flags: 'n',
          san: 'Qa4',
          lan: 'd1a4',
          before:
            'rn3rk1/p1p1qpp1/1p2b2p/3p4/3P4/4PN2/PP3PPP/2RQKB1R w K - 2 12',
          after:
            'rn3rk1/p1p1qpp1/1p2b2p/3p4/Q2P4/4PN2/PP3PPP/2R1KB1R b K - 3 12',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'c7',
          to: 'c5',
          flags: 'b',
          san: 'c5',
          lan: 'c7c5',
          before:
            'rn3rk1/p1p1qpp1/1p2b2p/3p4/Q2P4/4PN2/PP3PPP/2R1KB1R b K - 3 12',
          after:
            'rn3rk1/p3qpp1/1p2b2p/2pp4/Q2P4/4PN2/PP3PPP/2R1KB1R w K - 0 13',
        },
        {
          color: 'w',
          piece: 'q',
          from: 'a4',
          to: 'a3',
          flags: 'n',
          san: 'Qa3',
          lan: 'a4a3',
          before:
            'rn3rk1/p3qpp1/1p2b2p/2pp4/Q2P4/4PN2/PP3PPP/2R1KB1R w K - 0 13',
          after:
            'rn3rk1/p3qpp1/1p2b2p/2pp4/3P4/Q3PN2/PP3PPP/2R1KB1R b K - 1 13',
        },
        {
          color: 'b',
          piece: 'r',
          from: 'f8',
          to: 'c8',
          flags: 'n',
          san: 'Rc8',
          lan: 'f8c8',
          before:
            'rn3rk1/p3qpp1/1p2b2p/2pp4/3P4/Q3PN2/PP3PPP/2R1KB1R b K - 1 13',
          after:
            'rnr3k1/p3qpp1/1p2b2p/2pp4/3P4/Q3PN2/PP3PPP/2R1KB1R w K - 2 14',
        },
        {
          color: 'w',
          piece: 'b',
          from: 'f1',
          to: 'b5',
          flags: 'n',
          san: 'Bb5',
          lan: 'f1b5',
          before:
            'rnr3k1/p3qpp1/1p2b2p/2pp4/3P4/Q3PN2/PP3PPP/2R1KB1R w K - 2 14',
          after:
            'rnr3k1/p3qpp1/1p2b2p/1Bpp4/3P4/Q3PN2/PP3PPP/2R1K2R b K - 3 14',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'a7',
          to: 'a6',
          flags: 'n',
          san: 'a6',
          lan: 'a7a6',
          before:
            'rnr3k1/p3qpp1/1p2b2p/1Bpp4/3P4/Q3PN2/PP3PPP/2R1K2R b K - 3 14',
          after: 'rnr3k1/4qpp1/pp2b2p/1Bpp4/3P4/Q3PN2/PP3PPP/2R1K2R w K - 0 15',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'd4',
          to: 'c5',
          flags: 'c',
          san: 'dxc5',
          lan: 'd4c5',
          before:
            'rnr3k1/4qpp1/pp2b2p/1Bpp4/3P4/Q3PN2/PP3PPP/2R1K2R w K - 0 15',
          captured: 'p',
          after: 'rnr3k1/4qpp1/pp2b2p/1BPp4/8/Q3PN2/PP3PPP/2R1K2R b K - 0 15',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'b6',
          to: 'c5',
          flags: 'c',
          san: 'bxc5',
          lan: 'b6c5',
          before: 'rnr3k1/4qpp1/pp2b2p/1BPp4/8/Q3PN2/PP3PPP/2R1K2R b K - 0 15',
          captured: 'p',
          after: 'rnr3k1/4qpp1/p3b2p/1Bpp4/8/Q3PN2/PP3PPP/2R1K2R w K - 0 16',
        },
        {
          color: 'w',
          piece: 'k',
          from: 'e1',
          to: 'g1',
          flags: 'k',
          san: 'O-O',
          lan: 'e1g1',
          before: 'rnr3k1/4qpp1/p3b2p/1Bpp4/8/Q3PN2/PP3PPP/2R1K2R w K - 0 16',
          after: 'rnr3k1/4qpp1/p3b2p/1Bpp4/8/Q3PN2/PP3PPP/2R2RK1 b - - 1 16',
        },
        {
          color: 'b',
          piece: 'r',
          from: 'a8',
          to: 'a7',
          flags: 'n',
          san: 'Ra7',
          lan: 'a8a7',
          before: 'rnr3k1/4qpp1/p3b2p/1Bpp4/8/Q3PN2/PP3PPP/2R2RK1 b - - 1 16',
          after: '1nr3k1/r3qpp1/p3b2p/1Bpp4/8/Q3PN2/PP3PPP/2R2RK1 w - - 2 17',
        },
        {
          color: 'w',
          piece: 'b',
          from: 'b5',
          to: 'e2',
          flags: 'n',
          san: 'Be2',
          lan: 'b5e2',
          before: '1nr3k1/r3qpp1/p3b2p/1Bpp4/8/Q3PN2/PP3PPP/2R2RK1 w - - 2 17',
          after: '1nr3k1/r3qpp1/p3b2p/2pp4/8/Q3PN2/PP2BPPP/2R2RK1 b - - 3 17',
        },
        {
          color: 'b',
          piece: 'n',
          from: 'b8',
          to: 'd7',
          flags: 'n',
          san: 'Nd7',
          lan: 'b8d7',
          before: '1nr3k1/r3qpp1/p3b2p/2pp4/8/Q3PN2/PP2BPPP/2R2RK1 b - - 3 17',
          after: '2r3k1/r2nqpp1/p3b2p/2pp4/8/Q3PN2/PP2BPPP/2R2RK1 w - - 4 18',
        },
        {
          color: 'w',
          piece: 'n',
          from: 'f3',
          to: 'd4',
          flags: 'n',
          san: 'Nd4',
          lan: 'f3d4',
          before: '2r3k1/r2nqpp1/p3b2p/2pp4/8/Q3PN2/PP2BPPP/2R2RK1 w - - 4 18',
          after: '2r3k1/r2nqpp1/p3b2p/2pp4/3N4/Q3P3/PP2BPPP/2R2RK1 b - - 5 18',
        },
        {
          color: 'b',
          piece: 'q',
          from: 'e7',
          to: 'f8',
          flags: 'n',
          san: 'Qf8',
          lan: 'e7f8',
          before: '2r3k1/r2nqpp1/p3b2p/2pp4/3N4/Q3P3/PP2BPPP/2R2RK1 b - - 5 18',
          after: '2r2qk1/r2n1pp1/p3b2p/2pp4/3N4/Q3P3/PP2BPPP/2R2RK1 w - - 6 19',
        },
        {
          color: 'w',
          piece: 'n',
          from: 'd4',
          to: 'e6',
          flags: 'c',
          san: 'Nxe6',
          lan: 'd4e6',
          before:
            '2r2qk1/r2n1pp1/p3b2p/2pp4/3N4/Q3P3/PP2BPPP/2R2RK1 w - - 6 19',
          captured: 'b',
          after: '2r2qk1/r2n1pp1/p3N2p/2pp4/8/Q3P3/PP2BPPP/2R2RK1 b - - 0 19',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'f7',
          to: 'e6',
          flags: 'c',
          san: 'fxe6',
          lan: 'f7e6',
          before: '2r2qk1/r2n1pp1/p3N2p/2pp4/8/Q3P3/PP2BPPP/2R2RK1 b - - 0 19',
          captured: 'n',
          after: '2r2qk1/r2n2p1/p3p2p/2pp4/8/Q3P3/PP2BPPP/2R2RK1 w - - 0 20',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'e3',
          to: 'e4',
          flags: 'n',
          san: 'e4',
          lan: 'e3e4',
          before: '2r2qk1/r2n2p1/p3p2p/2pp4/8/Q3P3/PP2BPPP/2R2RK1 w - - 0 20',
          after: '2r2qk1/r2n2p1/p3p2p/2pp4/4P3/Q7/PP2BPPP/2R2RK1 b - - 0 20',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'd5',
          to: 'd4',
          flags: 'n',
          san: 'd4',
          lan: 'd5d4',
          before: '2r2qk1/r2n2p1/p3p2p/2pp4/4P3/Q7/PP2BPPP/2R2RK1 b - - 0 20',
          after: '2r2qk1/r2n2p1/p3p2p/2p5/3pP3/Q7/PP2BPPP/2R2RK1 w - - 0 21',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'f2',
          to: 'f4',
          flags: 'b',
          san: 'f4',
          lan: 'f2f4',
          before: '2r2qk1/r2n2p1/p3p2p/2p5/3pP3/Q7/PP2BPPP/2R2RK1 w - - 0 21',
          after: '2r2qk1/r2n2p1/p3p2p/2p5/3pPP2/Q7/PP2B1PP/2R2RK1 b - - 0 21',
        },
        {
          color: 'b',
          piece: 'q',
          from: 'f8',
          to: 'e7',
          flags: 'n',
          san: 'Qe7',
          lan: 'f8e7',
          before: '2r2qk1/r2n2p1/p3p2p/2p5/3pPP2/Q7/PP2B1PP/2R2RK1 b - - 0 21',
          after: '2r3k1/r2nq1p1/p3p2p/2p5/3pPP2/Q7/PP2B1PP/2R2RK1 w - - 1 22',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'e4',
          to: 'e5',
          flags: 'n',
          san: 'e5',
          lan: 'e4e5',
          before: '2r3k1/r2nq1p1/p3p2p/2p5/3pPP2/Q7/PP2B1PP/2R2RK1 w - - 1 22',
          after: '2r3k1/r2nq1p1/p3p2p/2p1P3/3p1P2/Q7/PP2B1PP/2R2RK1 b - - 0 22',
        },
        {
          color: 'b',
          piece: 'r',
          from: 'c8',
          to: 'b8',
          flags: 'n',
          san: 'Rb8',
          lan: 'c8b8',
          before:
            '2r3k1/r2nq1p1/p3p2p/2p1P3/3p1P2/Q7/PP2B1PP/2R2RK1 b - - 0 22',
          after: '1r4k1/r2nq1p1/p3p2p/2p1P3/3p1P2/Q7/PP2B1PP/2R2RK1 w - - 1 23',
        },
        {
          color: 'w',
          piece: 'b',
          from: 'e2',
          to: 'c4',
          flags: 'n',
          san: 'Bc4',
          lan: 'e2c4',
          before:
            '1r4k1/r2nq1p1/p3p2p/2p1P3/3p1P2/Q7/PP2B1PP/2R2RK1 w - - 1 23',
          after: '1r4k1/r2nq1p1/p3p2p/2p1P3/2Bp1P2/Q7/PP4PP/2R2RK1 b - - 2 23',
        },
        {
          color: 'b',
          piece: 'k',
          from: 'g8',
          to: 'h8',
          flags: 'n',
          san: 'Kh8',
          lan: 'g8h8',
          before: '1r4k1/r2nq1p1/p3p2p/2p1P3/2Bp1P2/Q7/PP4PP/2R2RK1 b - - 2 23',
          after: '1r5k/r2nq1p1/p3p2p/2p1P3/2Bp1P2/Q7/PP4PP/2R2RK1 w - - 3 24',
        },
        {
          color: 'w',
          piece: 'q',
          from: 'a3',
          to: 'h3',
          flags: 'n',
          san: 'Qh3',
          lan: 'a3h3',
          before: '1r5k/r2nq1p1/p3p2p/2p1P3/2Bp1P2/Q7/PP4PP/2R2RK1 w - - 3 24',
          after: '1r5k/r2nq1p1/p3p2p/2p1P3/2Bp1P2/7Q/PP4PP/2R2RK1 b - - 4 24',
        },
        {
          color: 'b',
          piece: 'n',
          from: 'd7',
          to: 'f8',
          flags: 'n',
          san: 'Nf8',
          lan: 'd7f8',
          before: '1r5k/r2nq1p1/p3p2p/2p1P3/2Bp1P2/7Q/PP4PP/2R2RK1 b - - 4 24',
          after: '1r3n1k/r3q1p1/p3p2p/2p1P3/2Bp1P2/7Q/PP4PP/2R2RK1 w - - 5 25',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'b2',
          to: 'b3',
          flags: 'n',
          san: 'b3',
          lan: 'b2b3',
          before: '1r3n1k/r3q1p1/p3p2p/2p1P3/2Bp1P2/7Q/PP4PP/2R2RK1 w - - 5 25',
          after: '1r3n1k/r3q1p1/p3p2p/2p1P3/2Bp1P2/1P5Q/P5PP/2R2RK1 b - - 0 25',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'a6',
          to: 'a5',
          flags: 'n',
          san: 'a5',
          lan: 'a6a5',
          before:
            '1r3n1k/r3q1p1/p3p2p/2p1P3/2Bp1P2/1P5Q/P5PP/2R2RK1 b - - 0 25',
          after: '1r3n1k/r3q1p1/4p2p/p1p1P3/2Bp1P2/1P5Q/P5PP/2R2RK1 w - - 0 26',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'f4',
          to: 'f5',
          flags: 'n',
          san: 'f5',
          lan: 'f4f5',
          before:
            '1r3n1k/r3q1p1/4p2p/p1p1P3/2Bp1P2/1P5Q/P5PP/2R2RK1 w - - 0 26',
          after: '1r3n1k/r3q1p1/4p2p/p1p1PP2/2Bp4/1P5Q/P5PP/2R2RK1 b - - 0 26',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'e6',
          to: 'f5',
          flags: 'c',
          san: 'exf5',
          lan: 'e6f5',
          before: '1r3n1k/r3q1p1/4p2p/p1p1PP2/2Bp4/1P5Q/P5PP/2R2RK1 b - - 0 26',
          captured: 'p',
          after: '1r3n1k/r3q1p1/7p/p1p1Pp2/2Bp4/1P5Q/P5PP/2R2RK1 w - - 0 27',
        },
        {
          color: 'w',
          piece: 'r',
          from: 'f1',
          to: 'f5',
          flags: 'c',
          san: 'Rxf5',
          lan: 'f1f5',
          before: '1r3n1k/r3q1p1/7p/p1p1Pp2/2Bp4/1P5Q/P5PP/2R2RK1 w - - 0 27',
          captured: 'p',
          after: '1r3n1k/r3q1p1/7p/p1p1PR2/2Bp4/1P5Q/P5PP/2R3K1 b - - 0 27',
        },
        {
          color: 'b',
          piece: 'n',
          from: 'f8',
          to: 'h7',
          flags: 'n',
          san: 'Nh7',
          lan: 'f8h7',
          before: '1r3n1k/r3q1p1/7p/p1p1PR2/2Bp4/1P5Q/P5PP/2R3K1 b - - 0 27',
          after: '1r5k/r3q1pn/7p/p1p1PR2/2Bp4/1P5Q/P5PP/2R3K1 w - - 1 28',
        },
        {
          color: 'w',
          piece: 'r',
          from: 'c1',
          to: 'f1',
          flags: 'n',
          san: 'Rcf1',
          lan: 'c1f1',
          before: '1r5k/r3q1pn/7p/p1p1PR2/2Bp4/1P5Q/P5PP/2R3K1 w - - 1 28',
          after: '1r5k/r3q1pn/7p/p1p1PR2/2Bp4/1P5Q/P5PP/5RK1 b - - 2 28',
        },
        {
          color: 'b',
          piece: 'q',
          from: 'e7',
          to: 'd8',
          flags: 'n',
          san: 'Qd8',
          lan: 'e7d8',
          before: '1r5k/r3q1pn/7p/p1p1PR2/2Bp4/1P5Q/P5PP/5RK1 b - - 2 28',
          after: '1r1q3k/r5pn/7p/p1p1PR2/2Bp4/1P5Q/P5PP/5RK1 w - - 3 29',
        },
        {
          color: 'w',
          piece: 'q',
          from: 'h3',
          to: 'g3',
          flags: 'n',
          san: 'Qg3',
          lan: 'h3g3',
          before: '1r1q3k/r5pn/7p/p1p1PR2/2Bp4/1P5Q/P5PP/5RK1 w - - 3 29',
          after: '1r1q3k/r5pn/7p/p1p1PR2/2Bp4/1P4Q1/P5PP/5RK1 b - - 4 29',
        },
        {
          color: 'b',
          piece: 'r',
          from: 'a7',
          to: 'e7',
          flags: 'n',
          san: 'Re7',
          lan: 'a7e7',
          before: '1r1q3k/r5pn/7p/p1p1PR2/2Bp4/1P4Q1/P5PP/5RK1 b - - 4 29',
          after: '1r1q3k/4r1pn/7p/p1p1PR2/2Bp4/1P4Q1/P5PP/5RK1 w - - 5 30',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'h2',
          to: 'h4',
          flags: 'b',
          san: 'h4',
          lan: 'h2h4',
          before: '1r1q3k/4r1pn/7p/p1p1PR2/2Bp4/1P4Q1/P5PP/5RK1 w - - 5 30',
          after: '1r1q3k/4r1pn/7p/p1p1PR2/2Bp3P/1P4Q1/P5P1/5RK1 b - - 0 30',
        },
        {
          color: 'b',
          piece: 'r',
          from: 'b8',
          to: 'b7',
          flags: 'n',
          san: 'Rbb7',
          lan: 'b8b7',
          before: '1r1q3k/4r1pn/7p/p1p1PR2/2Bp3P/1P4Q1/P5P1/5RK1 b - - 0 30',
          after: '3q3k/1r2r1pn/7p/p1p1PR2/2Bp3P/1P4Q1/P5P1/5RK1 w - - 1 31',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'e5',
          to: 'e6',
          flags: 'n',
          san: 'e6',
          lan: 'e5e6',
          before: '3q3k/1r2r1pn/7p/p1p1PR2/2Bp3P/1P4Q1/P5P1/5RK1 w - - 1 31',
          after: '3q3k/1r2r1pn/4P2p/p1p2R2/2Bp3P/1P4Q1/P5P1/5RK1 b - - 0 31',
        },
        {
          color: 'b',
          piece: 'r',
          from: 'b7',
          to: 'c7',
          flags: 'n',
          san: 'Rbc7',
          lan: 'b7c7',
          before: '3q3k/1r2r1pn/4P2p/p1p2R2/2Bp3P/1P4Q1/P5P1/5RK1 b - - 0 31',
          after: '3q3k/2r1r1pn/4P2p/p1p2R2/2Bp3P/1P4Q1/P5P1/5RK1 w - - 1 32',
        },
        {
          color: 'w',
          piece: 'q',
          from: 'g3',
          to: 'e5',
          flags: 'n',
          san: 'Qe5',
          lan: 'g3e5',
          before: '3q3k/2r1r1pn/4P2p/p1p2R2/2Bp3P/1P4Q1/P5P1/5RK1 w - - 1 32',
          after: '3q3k/2r1r1pn/4P2p/p1p1QR2/2Bp3P/1P6/P5P1/5RK1 b - - 2 32',
        },
        {
          color: 'b',
          piece: 'q',
          from: 'd8',
          to: 'e8',
          flags: 'n',
          san: 'Qe8',
          lan: 'd8e8',
          before: '3q3k/2r1r1pn/4P2p/p1p1QR2/2Bp3P/1P6/P5P1/5RK1 b - - 2 32',
          after: '4q2k/2r1r1pn/4P2p/p1p1QR2/2Bp3P/1P6/P5P1/5RK1 w - - 3 33',
        },
        {
          color: 'w',
          piece: 'p',
          from: 'a2',
          to: 'a4',
          flags: 'b',
          san: 'a4',
          lan: 'a2a4',
          before: '4q2k/2r1r1pn/4P2p/p1p1QR2/2Bp3P/1P6/P5P1/5RK1 w - - 3 33',
          after: '4q2k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P6/6P1/5RK1 b - - 0 33',
        },
        {
          color: 'b',
          piece: 'q',
          from: 'e8',
          to: 'd8',
          flags: 'n',
          san: 'Qd8',
          lan: 'e8d8',
          before: '4q2k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P6/6P1/5RK1 b - - 0 33',
          after: '3q3k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P6/6P1/5RK1 w - - 1 34',
        },
        {
          color: 'w',
          piece: 'r',
          from: 'f1',
          to: 'f2',
          flags: 'n',
          san: 'R1f2',
          lan: 'f1f2',
          before: '3q3k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P6/6P1/5RK1 w - - 1 34',
          after: '3q3k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P6/5RP1/6K1 b - - 2 34',
        },
        {
          color: 'b',
          piece: 'q',
          from: 'd8',
          to: 'e8',
          flags: 'n',
          san: 'Qe8',
          lan: 'd8e8',
          before: '3q3k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P6/5RP1/6K1 b - - 2 34',
          after: '4q2k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P6/5RP1/6K1 w - - 3 35',
        },
        {
          color: 'w',
          piece: 'r',
          from: 'f2',
          to: 'f3',
          flags: 'n',
          san: 'R2f3',
          lan: 'f2f3',
          before: '4q2k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P6/5RP1/6K1 w - - 3 35',
          after: '4q2k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P3R2/6P1/6K1 b - - 4 35',
        },
        {
          color: 'b',
          piece: 'q',
          from: 'e8',
          to: 'd8',
          flags: 'n',
          san: 'Qd8',
          lan: 'e8d8',
          before: '4q2k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P3R2/6P1/6K1 b - - 4 35',
          after: '3q3k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P3R2/6P1/6K1 w - - 5 36',
        },
        {
          color: 'w',
          piece: 'b',
          from: 'c4',
          to: 'd3',
          flags: 'n',
          san: 'Bd3',
          lan: 'c4d3',
          before: '3q3k/2r1r1pn/4P2p/p1p1QR2/P1Bp3P/1P3R2/6P1/6K1 w - - 5 36',
          after: '3q3k/2r1r1pn/4P2p/p1p1QR2/P2p3P/1P1B1R2/6P1/6K1 b - - 6 36',
        },
        {
          color: 'b',
          piece: 'q',
          from: 'd8',
          to: 'e8',
          flags: 'n',
          san: 'Qe8',
          lan: 'd8e8',
          before: '3q3k/2r1r1pn/4P2p/p1p1QR2/P2p3P/1P1B1R2/6P1/6K1 b - - 6 36',
          after: '4q2k/2r1r1pn/4P2p/p1p1QR2/P2p3P/1P1B1R2/6P1/6K1 w - - 7 37',
        },
        {
          color: 'w',
          piece: 'q',
          from: 'e5',
          to: 'e4',
          flags: 'n',
          san: 'Qe4',
          lan: 'e5e4',
          before: '4q2k/2r1r1pn/4P2p/p1p1QR2/P2p3P/1P1B1R2/6P1/6K1 w - - 7 37',
          after: '4q2k/2r1r1pn/4P2p/p1p2R2/P2pQ2P/1P1B1R2/6P1/6K1 b - - 8 37',
        },
        {
          color: 'b',
          piece: 'n',
          from: 'h7',
          to: 'f6',
          flags: 'n',
          san: 'Nf6',
          lan: 'h7f6',
          before: '4q2k/2r1r1pn/4P2p/p1p2R2/P2pQ2P/1P1B1R2/6P1/6K1 b - - 8 37',
          after: '4q2k/2r1r1p1/4Pn1p/p1p2R2/P2pQ2P/1P1B1R2/6P1/6K1 w - - 9 38',
        },
        {
          color: 'w',
          piece: 'r',
          from: 'f5',
          to: 'f6',
          flags: 'c',
          captured: 'n',
          san: 'Rxf6',
          lan: 'f5f6',
          before: '4q2k/2r1r1p1/4Pn1p/p1p2R2/P2pQ2P/1P1B1R2/6P1/6K1 w - - 9 38',
          after: '4q2k/2r1r1p1/4PR1p/p1p5/P2pQ2P/1P1B1R2/6P1/6K1 b - - 0 38',
        },
        {
          color: 'b',
          piece: 'p',
          from: 'g7',
          to: 'f6',
          flags: 'c',
          captured: 'r',
          san: 'gxf6',
          lan: 'g7f6',
          before: '4q2k/2r1r1p1/4PR1p/p1p5/P2pQ2P/1P1B1R2/6P1/6K1 b - - 0 38',
          after: '4q2k/2r1r3/4Pp1p/p1p5/P2pQ2P/1P1B1R2/6P1/6K1 w - - 0 39',
        },
        {
          color: 'w',
          piece: 'r',
          from: 'f3',
          to: 'f6',
          flags: 'c',
          captured: 'p',
          san: 'Rxf6',
          lan: 'f3f6',
          before: '4q2k/2r1r3/4Pp1p/p1p5/P2pQ2P/1P1B1R2/6P1/6K1 w - - 0 39',
          after: '4q2k/2r1r3/4PR1p/p1p5/P2pQ2P/1P1B4/6P1/6K1 b - - 0 39',
        },
        {
          color: 'b',
          piece: 'k',
          from: 'h8',
          to: 'g8',
          flags: 'n',
          san: 'Kg8',
          lan: 'h8g8',
          before: '4q2k/2r1r3/4PR1p/p1p5/P2pQ2P/1P1B4/6P1/6K1 b - - 0 39',
          after: '4q1k1/2r1r3/4PR1p/p1p5/P2pQ2P/1P1B4/6P1/6K1 w - - 1 40',
        },
        {
          color: 'w',
          piece: 'b',
          from: 'd3',
          to: 'c4',
          flags: 'n',
          san: 'Bc4',
          lan: 'd3c4',
          before: '4q1k1/2r1r3/4PR1p/p1p5/P2pQ2P/1P1B4/6P1/6K1 w - - 1 40',
          after: '4q1k1/2r1r3/4PR1p/p1p5/P1BpQ2P/1P6/6P1/6K1 b - - 2 40',
        },
        {
          color: 'b',
          piece: 'k',
          from: 'g8',
          to: 'h8',
          flags: 'n',
          san: 'Kh8',
          lan: 'g8h8',
          before: '4q1k1/2r1r3/4PR1p/p1p5/P1BpQ2P/1P6/6P1/6K1 b - - 2 40',
          after: '4q2k/2r1r3/4PR1p/p1p5/P1BpQ2P/1P6/6P1/6K1 w - - 3 41',
        },
        {
          color: 'w',
          piece: 'q',
          from: 'e4',
          to: 'f4',
          flags: 'n',
          san: 'Qf4',
          lan: 'e4f4',
          before: '4q2k/2r1r3/4PR1p/p1p5/P1BpQ2P/1P6/6P1/6K1 w - - 3 41',
          after: '4q2k/2r1r3/4PR1p/p1p5/P1Bp1Q1P/1P6/6P1/6K1 b - - 4 41',
        },
      ],
    },
  ]

  tests.forEach((t, i) => {
    it('History ' + i, () => {
      chess.reset()

      for (let j = 0; j < t.moves.length; j++) {
        chess.move(t.moves[j])
      }

      const history = chess.history({ verbose: t.verbose })
      expect(chess.fen()).toEqual(t.fen)
      expect(history.length).toEqual(t.moves.length)

      for (let j = 0; j < t.moves.length; j++) {
        expect(history[j]).toEqual(t.moves[j])
      }
    })
  })

  test('History - PGN Setup', () => {
    let pgn = `[SetUp "1"]
[FEN "r1bqk1nr/pppp1ppp/2n5/4p3/1bB1P3/2P2N2/P2P1PPP/RNBQK2R b KQkq - 0 1"]

1. ... Ba5 2. O-O d6
3. d4`

    const moves = [
      {
        color: 'b',
        piece: 'b',
        from: 'b4',
        to: 'a5',
        lan: 'b4a5',
        san: 'Ba5',
        flags: 'n',
        before:
          'r1bqk1nr/pppp1ppp/2n5/4p3/1bB1P3/2P2N2/P2P1PPP/RNBQK2R b KQkq - 0 1',
        after:
          'r1bqk1nr/pppp1ppp/2n5/b3p3/2B1P3/2P2N2/P2P1PPP/RNBQK2R w KQkq - 1 2',
      },
      {
        color: 'w',
        piece: 'k',
        from: 'e1',
        to: 'g1',
        lan: 'e1g1',
        san: 'O-O',
        flags: 'k',
        before:
          'r1bqk1nr/pppp1ppp/2n5/b3p3/2B1P3/2P2N2/P2P1PPP/RNBQK2R w KQkq - 1 2',
        after:
          'r1bqk1nr/pppp1ppp/2n5/b3p3/2B1P3/2P2N2/P2P1PPP/RNBQ1RK1 b kq - 2 2',
      },
      {
        color: 'b',
        piece: 'p',
        from: 'd7',
        to: 'd6',
        lan: 'd7d6',
        san: 'd6',
        flags: 'n',
        before:
          'r1bqk1nr/pppp1ppp/2n5/b3p3/2B1P3/2P2N2/P2P1PPP/RNBQ1RK1 b kq - 2 2',
        after:
          'r1bqk1nr/ppp2ppp/2np4/b3p3/2B1P3/2P2N2/P2P1PPP/RNBQ1RK1 w kq - 0 3',
      },
      {
        color: 'w',
        piece: 'p',
        from: 'd2',
        to: 'd4',
        san: 'd4',
        lan: 'd2d4',
        flags: 'b',
        before:
          'r1bqk1nr/ppp2ppp/2np4/b3p3/2B1P3/2P2N2/P2P1PPP/RNBQ1RK1 w kq - 0 3',
        after:
          'r1bqk1nr/ppp2ppp/2np4/b3p3/2BPP3/2P2N2/P4PPP/RNBQ1RK1 b kq - 0 3',
      },
    ]

    const chess = new Chess()
    chess.loadPgn(pgn)

    const history = chess.history({ verbose: true })

    moves.forEach((move, i) => {
      expect(history[i]).toEqual(move)
    })
  })
})
