package org.onjava8.teninterface;

import javax.annotation.processing.*;
import javax.annotation.processing.Processor;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.Set;
import java.util.logging.Filter;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 9:22 下午
 */
public class FilterAdapter implements Processor {

    /**
     * Returns the options recognized by this processor.  An
     * implementation of the processing tool must provide a way to
     * pass processor-specific options distinctly from options passed
     * to the tool itself, see {@link ProcessingEnvironment#getOptions
     * getOptions}.
     *
     * <p>Each string returned in the set must be a period separated
     * sequence of {@linkplain
     * SourceVersion#isIdentifier identifiers}:
     *
     * <blockquote>
     * <dl>
     * <dt><i>SupportedOptionString:</i>
     * <dd><i>Identifiers</i>
     *
     * <dt><i>Identifiers:</i>
     * <dd> <i>Identifier</i>
     * <dd> <i>Identifier</i> {@code .} <i>Identifiers</i>
     *
     * <dt><i>Identifier:</i>
     * <dd>Syntactic identifier, including keywords and literals
     * </dl>
     * </blockquote>
     *
     * <p> A tool might use this information to determine if any
     * options provided by a user are unrecognized by any processor,
     * in which case it may wish to report a warning.
     *
     * @return the options recognized by this processor or an
     * empty collection if none
     * @see SupportedOptions
     */
    @Override
    public Set<String> getSupportedOptions() {
        return null;
    }

    /**
     * Returns the names of the annotation types supported by this
     * processor.  An element of the result may be the canonical
     * (fully qualified) name of a supported annotation type.
     * Alternately it may be of the form &quot;<tt><i>name</i>.*</tt>&quot;
     * representing the set of all annotation types with canonical
     * names beginning with &quot;<tt><i>name.</i></tt>&quot;.  Finally, {@code
     * "*"} by itself represents the set of all annotation types,
     * including the empty set.  Note that a processor should not
     * claim {@code "*"} unless it is actually processing all files;
     * claiming unnecessary annotations may cause a performance
     * slowdown in some environments.
     *
     * <p>Each string returned in the set must be accepted by the
     * following grammar:
     *
     * <blockquote>
     * <dl>
     * <dt><i>SupportedAnnotationTypeString:</i>
     * <dd><i>TypeName</i> <i>DotStar</i><sub><i>opt</i></sub>
     * <dd><tt>*</tt>
     *
     * <dt><i>DotStar:</i>
     * <dd><tt>.</tt> <tt>*</tt>
     * </dl>
     * </blockquote>
     * <p>
     * where <i>TypeName</i> is as defined in
     * <cite>The Java&trade; Language Specification</cite>.
     *
     * @return the names of the annotation types supported by this processor
     * @jls 3.8 Identifiers
     * @jls 6.5.5 Meaning of Type Names
     * @see SupportedAnnotationTypes
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return null;
    }

    /**
     * Returns the latest source version supported by this annotation
     * processor.
     *
     * @return the latest source version supported by this annotation
     * processor.
     * @see SupportedSourceVersion
     * @see ProcessingEnvironment#getSourceVersion
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return null;
    }

    /**
     * Initializes the processor with the processing environment.
     *
     * @param processingEnv environment for facilities the tool framework
     *                      provides to the processor
     */
    @Override
    public void init(ProcessingEnvironment processingEnv) {

    }

    /**
     * Processes a set of annotation types on type elements
     * originating from the prior round and returns whether or not
     * these annotation types are claimed by this processor.  If {@code
     * true} is returned, the annotation types are claimed and subsequent
     * processors will not be asked to process them; if {@code false}
     * is returned, the annotation types are unclaimed and subsequent
     * processors may be asked to process them.  A processor may
     * always return the same boolean value or may vary the result
     * based on chosen criteria.
     *
     * <p>The input set will be empty if the processor supports {@code
     * "*"} and the root elements have no annotations.  A {@code
     * Processor} must gracefully handle an empty set of annotations.
     *
     * @param annotations the annotation types requested to be processed
     * @param roundEnv    environment for information about the current and prior round
     * @return whether or not the set of annotation types are claimed by this processor
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }

    /**
     * Returns to the tool infrastructure an iterable of suggested
     * completions to an annotation.  Since completions are being asked
     * for, the information provided about the annotation may be
     * incomplete, as if for a source code fragment. A processor may
     * return an empty iterable.  Annotation processors should focus
     * their efforts on providing completions for annotation members
     * with additional validity constraints known to the processor, for
     * example an {@code int} member whose value should lie between 1
     * and 10 or a string member that should be recognized by a known
     * grammar, such as a regular expression or a URL.
     *
     * <p>Since incomplete programs are being modeled, some of the
     * parameters may only have partial information or may be {@code
     * null}.  At least one of {@code element} and {@code userText}
     * must be non-{@code null}.  If {@code element} is non-{@code
     * null}, {@code annotation} and {@code member} may be {@code
     * null}.  Processors may not throw a {@code NullPointerException}
     * if some parameters are {@code null}; if a processor has no
     * completions to offer based on the provided information, an
     * empty iterable can be returned.  The processor may also return
     * a single completion with an empty value string and a message
     * describing why there are no completions.
     *
     * <p>Completions are informative and may reflect additional
     * validity checks performed by annotation processors.  For
     * example, consider the simple annotation:
     *
     * <blockquote>
     * <pre>
     * &#064;MersennePrime {
     *    int value();
     * }
     * </pre>
     * </blockquote>
     * <p>
     * (A Mersenne prime is prime number of the form
     * 2<sup><i>n</i></sup> - 1.) Given an {@code AnnotationMirror}
     * for this annotation type, a list of all such primes in the
     * {@code int} range could be returned without examining any other
     * arguments to {@code getCompletions}:
     *
     * <blockquote>
     * <pre>
     * import static javax.annotation.processing.Completions.*;
     * ...
     * return Arrays.asList({@link Completions#of(String) of}(&quot;3&quot;),
     *                      of(&quot;7&quot;),
     *                      of(&quot;31&quot;),
     *                      of(&quot;127&quot;),
     *                      of(&quot;8191&quot;),
     *                      of(&quot;131071&quot;),
     *                      of(&quot;524287&quot;),
     *                      of(&quot;2147483647&quot;));
     * </pre>
     * </blockquote>
     * <p>
     * A more informative set of completions would include the number
     * of each prime:
     *
     * <blockquote>
     * <pre>
     * return Arrays.asList({@link Completions#of(String, String) of}(&quot;3&quot;,          &quot;M2&quot;),
     *                      of(&quot;7&quot;,          &quot;M3&quot;),
     *                      of(&quot;31&quot;,         &quot;M5&quot;),
     *                      of(&quot;127&quot;,        &quot;M7&quot;),
     *                      of(&quot;8191&quot;,       &quot;M13&quot;),
     *                      of(&quot;131071&quot;,     &quot;M17&quot;),
     *                      of(&quot;524287&quot;,     &quot;M19&quot;),
     *                      of(&quot;2147483647&quot;, &quot;M31&quot;));
     * </pre>
     * </blockquote>
     * <p>
     * However, if the {@code userText} is available, it can be checked
     * to see if only a subset of the Mersenne primes are valid.  For
     * example, if the user has typed
     *
     * <blockquote>
     * <code>
     * &#064;MersennePrime(1
     * </code>
     * </blockquote>
     * <p>
     * the value of {@code userText} will be {@code "1"}; and only
     * two of the primes are possible completions:
     *
     * <blockquote>
     * <pre>
     * return Arrays.asList(of(&quot;127&quot;,        &quot;M7&quot;),
     *                      of(&quot;131071&quot;,     &quot;M17&quot;));
     * </pre>
     * </blockquote>
     * <p>
     * Sometimes no valid completion is possible.  For example, there
     * is no in-range Mersenne prime starting with 9:
     *
     * <blockquote>
     * <code>
     * &#064;MersennePrime(9
     * </code>
     * </blockquote>
     * <p>
     * An appropriate response in this case is to either return an
     * empty list of completions,
     *
     * <blockquote>
     * <pre>
     * return Collections.emptyList();
     * </pre>
     * </blockquote>
     * <p>
     * or a single empty completion with a helpful message
     *
     * <blockquote>
     * <pre>
     * return Arrays.asList(of(&quot;&quot;, &quot;No in-range Mersenne primes start with 9&quot;));
     * </pre>
     * </blockquote>
     *
     * @param element    the element being annotated
     * @param annotation the (perhaps partial) annotation being
     *                   applied to the element
     * @param member     the annotation member to return possible completions for
     * @param userText   source code text to be completed
     * @return suggested completions to the annotation
     */
    @Override
    public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member, String userText) {
        return null;
    }

    Filter filter;
    FilterAdapter(Filter filter){
        this.filter = filter;
    }

    @Override
    public String name(){
        return filter.notify();
    }
}
