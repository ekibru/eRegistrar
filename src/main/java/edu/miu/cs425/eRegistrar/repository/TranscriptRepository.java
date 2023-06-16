package edu.miu.cs425.eRegistrar.repository;

import edu.miu.cs425.eRegistrar.enitity.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscriptRepository extends JpaRepository<Transcript,Long> {
}
