# be.json

Created by Olexandr Zhydenko ((olexandr.zhydenko (at) gmail.com)
Based on the file: hyph_be_BY.dic
Created by: Alex Buloichik <alex73mail at gmail dot com>
Corrected by: Liasovich Sviatlana <xelj.gjkz atbk dot ru>
License: LGPL

# bn.json

// For questions about the Bengali hyphenation patterns
// ask Santhosh Thottingal (santhosh dot thottingal at gmail dot com)

# ca.json

// For questions about the Catalan hyphenation patterns
// ask Jordi Rosell (jroselln at gmail dot com)

# cs.json

// For questions about the Czech hyphenation patterns
// ask Martin Hasoň (martin dot hason at gmail dot com)

# el-monoton.json

// Hyphenation patterns for Modern Monotonic Greek.
// Created by Dimitrios Filippou with some ideas borrowed from 
// Yannis Haralambous, Kostis Dryllerakis and Claudio Beccari.
// From http://tug.org/svn/texhyphen/branches/ptex/hyph-utf8/tex/generic/hyph-utf8/patterns/tex/hyph-el-monoton.tex
// Converted by Pablo Rodríguez (hyphenator at pragmata dot tk)

# el-polyton

// Hyphenation patterns for Modern Polytonic Greek.
// Created by Dimitrios Filippou with some ideas borrowed from 
// Yannis Haralambous, Kostis Dryllerakis and Claudio Beccari.
// From http://tug.org/svn/texhyphen/branches/ptex/hyph-utf8/tex/generic/hyph-utf8/patterns/tex/hyph-el-polyton.tex
// Converted by Pablo Rodríguez (hyphenator at pragmata dot tk)

# en-gb

// The en-GB hyphenation patterns are retrieved from
// http://tug_org/svn/texhyphen/trunk/collaboration/repository/hyphenator/

# en-us

// The en-US hyphenation patterns are retrieved from
// http://tug_org/svn/texhyphen/trunk/collaboration/repository/hyphenator/

# es

// For questions about the spanish hyphenation patterns
// ask Luis Pabon (lpabon at metagrama dot es)

# fr

// The french hyphenation patterns are retrieved from
// http://tug_org/svn/texhyphen/trunk/collaboration/repository/hyphenator/

# grc

// Hyphenation patterns for Ancient Greek.
// Created by Dimitrios Filippou with some ideas borrowed from 
// Yannis Haralambous, Kostis Dryllerakis and Claudio Beccari.
// From http://tug.org/svn/texhyphen/branches/ptex/hyph-utf8/tex/generic/hyph-utf8/patterns/tex/hyph-grc.tex
// Converted by Pablo Rodríguez (hyphenator at pragmata dot tk)

# gu

// For questions about the Gujarati hyphenation patterns
// ask Santhosh Thottingal (santhosh dot thottingal at gmail dot com)

# hi

// For questions about the Hindi hyphenation patterns
// ask Santhosh Thottingal (santhosh dot thottingal at gmail dot com)

# hu

// For questions about the hungarian hyphenation patterns
// ask Nagy Péter (nagy dot pite at gmail dot com)

# hy

// For questions about the armenian hyphenation patterns
// ask Sahak Petrosyan (sahak at mit dot edu)

# it

// The italian hyphenation patterns are retrieved from 
// http://www.ctan.org/tex-archive/language/hyphenation/ithyph.tex

# kn

// For questions about the Kannada hyphenation patterns
// ask Santhosh Thottingal (santhosh dot thottingal at gmail dot com)

# la

// Latin hyphenation patterns converted by
// Pablo Rodríguez (hyphenator at pragmata dot tk)
// based on LaTeX Latin hyphenation patterns by Claudio Beccari
// (http://tug.ctan.org/tex-archive/language/hyphenation/lahyph.tex)

# lt

// For questions about the Lithuanian hyphenation patterns
// ask Rogutės Sparnuotos (rogutes at googlemail dot com)

# lv

// For questions about the latvian hyphenation patterns
// ask Kristaps Karlsons (kristaps dot karlsons at gmail dot com)

# ml

// For questions about the Malayalam hyphenation patterns
// ask Santhosh Thottingal (santhosh dot thottingal at gmail dot com)

# nb-no

// The norwegian hyphenation patterns were retrieved from 
// http://www.ctan.org/language/hyph-utf8/tex/generic/hyph-utf8/patterns/tex/hyph-no.tex
// and adapted to hyphenator.js format by Erik Erik Seierstad (erik dot seierstad at gmail dot com).

// % This file is part of hyph-utf8 package and resulted from
// % semi-manual conversions of hyphenation patterns into UTF-8 in June 2008.
// %
// % Source: nohyphbx.tex (2007-02-07)
// % Author:
// %
// % The above mentioned file should become obsolete,
// % and the author of the original file should preferaby modify this file instead.
// %
// % Modificatios were needed in order to support native UTF-8 engines,
// % but functionality (hopefully) didn't change in any way, at least not intentionally.
// % This file is no longer stand-alone; at least for 8-bit engines
// % you probably want to use loadhyph-foo.tex (which will load this file) instead.
// %
// % Modifications were done by Jonathan Kew, Mojca Miklavec & Arthur Reutenauer
// % with help & support from:
// % - Karl Berry, who gave us free hands and all resources
// % - Taco Hoekwater, with useful macros
// % - Hans Hagen, who did the unicodifisation of patterns already long before
// %               and helped with testing, suggestions and bug reports
// % - Norbert Preining, who tested & integrated patterns into TeX Live
// %
// % However, the "copyright/copyleft" owner of patterns remains the original author.
// %
// % The copyright statement of this file is thus:
// %
// %    Do with this file whatever needs to be done in future for the sake of
// %    "a better world" as long as you respect the copyright of original file.
// %    If you're the original author of patterns or taking over a new revolution,
// %    plese remove all of the TUG comments & credits that we added here -
// %    you are the Queen / the King, we are only the servants.
// %
// % If you want to change this file, rather than uploading directly to CTAN,
// % we would be grateful if you could send it to us (http://tug.org/tex-hyphen)
// % or ask for credentials for SVN repository and commit it yourself;
// % we will then upload the whole "package" to CTAN.
// %
// % Before a new "pattern-revolution" starts,
// % please try to follow some guidelines if possible:
// %
// % - \lccode is *forbidden*, and I really mean it
// % - all the patterns should be in UTF-8
// % - the only "allowed" TeX commands in this file are: \patterns, \hyphenation,
// %   and if you really cannot do without, also \input and \message
// % - in particular, please no \catcode or \lccode changes,
// %   they belong to loadhyph-foo.tex,
// %   and no \lefthyphenmin and \righthyphenmin,
// %   they have no influence here and belong elsewhere
// % - \begingroup and/or \endinput is not needed
// % - feel free to do whatever you want inside comments
// %
// % We know that TeX is extremely powerful, but give a stupid parser
// % at least a chance to read your patterns.
// %
// % For more unformation see
// %
// %    http://tug.org/tex-hyphen
// %
// %------------------------------------------------------------------------------
// %
// % TeX hyphenation patterns for Norwegian
// % 
// % version of 2007-02-07.
// % Patterns of January 25, 2005, with later additions and changes
// %
// % Copyright (C) 2004, 2005 Rune Kleveland, Ole Michael Selberg.
// % Copying and distribution of this file, with or without modification,
// % are permitted in any medium without royalty provided the copyright
// % notice and this notice are preserved.
// % 
// % Please send bugs or suggestions to tex-live (at) tug.org.
// % 
// % Originally generated by a script written by Rune Kleveland
// % from dictionaries available from 
// % http://folk.uio.no/runekl/dictionary.html.
// %
// % Adjusted manually by Ole Michael Selberg to prevent
// % numerous wrong hyphenations, especially in compounds.
// %
// % Changes from the former version of 2005-06-29:
// % 388 new patterns. Some old patterns have been deleted or changed.
// %
// % In Kleveland's nohyphb.tex there are 26017 patterns.
// % This version of the revised nohyphbx.tex contains 27149 patterns 
// % --- plus 45 exceptions in the \hyphenation-list
// % (which you may change to suit your personal needs).
// %
// % To load these hyphenation patterns the parameters 
// % of TeX must have the following minimum values:
// %   trie_size = 33385 
// %   trie_op_size = 815
// % (The corresponding values for nohyphb.tex are
// %   trie_size = 31900    trie_op_size = 636)
// % If you want to load more than one set of hyphenation 
// % patterns the parameters have to be set to a value 
// % larger than or equal to the sum of all required values
// % for each set.
// %
// % Notes on other Norwegian hyphenation pattern files, from Dag Langmyhr,
// % tex-live mail of 29 Jun 2005 11:26:21 +0200.
// % nohyph.tex -- manually created by Ivar Aavatsmark and others;
// %   hyphenate according to pre-1973 rules; no longer recommended for use.
// %   (Sometimes also known as nohyph1.tex.)
// % nohyph2.tex -- created by Dag and a student; the present file,
// %   nohyphbx.tex, is more extensive and is recommended.


# nl

// For questions about the dutch hyphenation patterns
// ask Remco Bloemen (remco dot bloemen at gmail dot com)

# or

// For questions about the Oriya hyphenation patterns
// ask Santhosh Thottingal (santhosh dot thottingal at gmail dot com)

# pa

// For questions about the Panjabi hyphenation patterns
// ask Santhosh Thottingal (santhosh dot thottingal at gmail dot com)

# pt

// For questions about the portuguese hyphenation patterns
// ask Lailson Bandeira (lailsonbm at gmail dot com)
// based on LaTeX patterns in Portuguese, by Pedro J. de Rezende and J.Joao Dias Almeida (http://www.ctan.org/tex-archive/language/hyph-utf8/tex/generic/hyph-utf8/patterns/)

# ru

// For questions about the russian hyphenation patterns ask
// crymos at yandex dot ru
// Вопросы по русскоязычным таблицам переноса отправлять на адрес
// crymos точка yandex собака ru

# sk

// Created based on sk-spell.sk.cx
// For questions about the slovak hyphenation patterns
// ask Zdenko Podobný (zdenop at gmail dot com)

# sl

// For questions about the Slovenian hyphenation patterns
// ask Mojca Miklavec (mojca dot miklavec dot lists at gmail dot com)

# sv

// Swedish hyphenation patterns by Jan Michael Rynning, jmr@nada.kth.se
// Patterns modified for Hyphenator by Andreas Johansson, andreas@ibuypink.com

# ta

// For questions about the Tamil hyphenation patterns
// ask Santhosh Thottingal (santhosh dot thottingal at gmail dot com)

# te

// For questions about the Telugu hyphenation patterns
// ask Santhosh Thottingal (santhosh dot thottingal at gmail dot com)

# tr

// For questions about the turkish hyphenation patterns ask
// Andreas Lappe nd at off-pist dot de

# uk

// For questions about the Ukrainian hyphenation patterns
// ask Alexey Grekov (athens at ukr dot net)
 